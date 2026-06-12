const KEYWORD_PATTERN = /\b(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|if|implements|import|instanceof|int|interface|long|native|new|null|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|true|try|var|void|volatile|while|record|sealed|permits|non-sealed|false)\b/g;
const NUMBER_PATTERN = /\b(0[xX][\da-fA-F_]+|\d+(?:\.\d+)?(?:[eE][+-]?\d+)?[dDfFlL]?)\b/g;
const ANNOTATION_PATTERN = /(^|[^\w])(@[A-Za-z_]\w*)/g;
const URL_PATTERN = /(https?:\/\/[^\s*<]+)/g;

let activeModal = null;
let activeModalClose = null;

document.addEventListener('click', (event) => {
    const anchor = event.target.closest('a[href]');
    if (!anchor) {
        return;
    }

    if (event.metaKey || event.ctrlKey || event.shiftKey || event.altKey) {
        return;
    }

    const url = new URL(anchor.href, window.location.href);
    if (!url.pathname.endsWith('.java')) {
        return;
    }

    event.preventDefault();
    openFile(anchor.href, anchor.textContent.trim());
});

document.addEventListener('keydown', (event) => {
    if (event.key === 'Escape' && activeModalClose) {
        activeModalClose();
    }
});

async function openFile(link, label) {
    const modal = createModal(label || fileNameFromLink(link), link);
    setModalStatus(modal.body, 'Loading source...');

    try {
        const response = await fetch(link, { credentials: 'same-origin' });
        if (!response.ok) {
            throw new Error(`Request failed with status ${response.status}`);
        }

        const javaCode = await response.text();
        renderJavaSource(modal.body, javaCode);
    } catch (error) {
        setModalStatus(
            modal.body,
            `Unable to load this Java file. ${error.message}`,
            true
        );
    }
}

function createModal(title, link) {
    if (activeModalClose) {
        activeModalClose();
    }

    const overlay = document.createElement('div');
    overlay.className = 'java-modal-overlay';

    const panel = document.createElement('div');
    panel.className = 'java-modal';
    panel.setAttribute('role', 'dialog');
    panel.setAttribute('aria-modal', 'true');
    panel.setAttribute('aria-label', title || 'Java source');

    const header = document.createElement('div');
    header.className = 'java-modal-header';

    const titleBlock = document.createElement('div');
    titleBlock.className = 'java-modal-title-block';

    const heading = document.createElement('div');
    heading.className = 'java-modal-title';
    heading.textContent = title || fileNameFromLink(link);

    const subtitle = document.createElement('div');
    subtitle.className = 'java-modal-subtitle';
    subtitle.textContent = fileNameFromLink(link);

    titleBlock.appendChild(heading);
    titleBlock.appendChild(subtitle);

    const closeButton = document.createElement('button');
    closeButton.type = 'button';
    closeButton.className = 'java-modal-close';
    closeButton.setAttribute('aria-label', 'Close source viewer');
    closeButton.textContent = 'Close';

    header.appendChild(titleBlock);
    header.appendChild(closeButton);

    const body = document.createElement('div');
    body.className = 'java-modal-body';

    panel.appendChild(header);
    panel.appendChild(body);
    overlay.appendChild(panel);
    document.body.appendChild(overlay);
    document.body.classList.add('java-modal-open');

    const closeModal = () => {
        overlay.remove();
        document.body.classList.remove('java-modal-open');
        if (activeModal === overlay) {
            activeModal = null;
            activeModalClose = null;
        }
    };

    closeButton.addEventListener('click', closeModal);
    overlay.addEventListener('click', (event) => {
        if (event.target === overlay) {
            closeModal();
        }
    });

    activeModal = overlay;
    activeModalClose = closeModal;
    closeButton.focus();

    return { body, closeModal };
}

function setModalStatus(container, message, isError) {
    container.innerHTML = '';

    const status = document.createElement('div');
    status.className = isError ? 'java-modal-status java-modal-status-error' : 'java-modal-status';
    status.textContent = message;

    container.appendChild(status);
}

function renderJavaSource(container, javaCode) {
    container.innerHTML = '';

    const pre = document.createElement('pre');
    pre.className = 'java-source-viewer';

    const code = document.createElement('code');
    code.className = 'language-java';
    code.innerHTML = beautifyCode(javaCode);

    pre.appendChild(code);
    container.appendChild(pre);
}

function beautifyCode(javaCode) {
    let highlightedCode = escapeHtml(javaCode).replace(/\t/g, '    ');
    const tokens = [];

    highlightedCode = preserveTokens(highlightedCode, /\/\*[\s\S]*?\*\//g, 'comment', tokens);
    highlightedCode = preserveTokens(highlightedCode, /\/\/.*$/gm, 'comment', tokens);
    highlightedCode = preserveTokens(highlightedCode, /"(?:\\.|[^"\\])*"/g, 'string', tokens);
    highlightedCode = preserveTokens(highlightedCode, /'(?:\\.|[^'\\])'/g, 'string', tokens);

    highlightedCode = highlightedCode.replace(ANNOTATION_PATTERN, '$1<span class="annotation">$2</span>');
    highlightedCode = highlightedCode.replace(KEYWORD_PATTERN, '<span class="keyword">$1</span>');
    highlightedCode = highlightedCode.replace(NUMBER_PATTERN, '<span class="number">$1</span>');

    return restoreTokens(highlightedCode, tokens);
}

function preserveTokens(source, pattern, className, tokens) {
    return source.replace(pattern, (match) => {
        const placeholder = `__JAVA_TOKEN_${tokens.length}__`;
        const tokenText = className === 'comment' ? linkifyCommentUrls(match) : match;
        tokens.push(`<span class="${className}">${tokenText}</span>`);
        return placeholder;
    });
}

function linkifyCommentUrls(text) {
    return text.replace(URL_PATTERN, (url) => {
        return `<a href="${url}" target="_blank" rel="noopener noreferrer">${url}</a>`;
    });
}

function restoreTokens(source, tokens) {
    return source.replace(/__JAVA_TOKEN_(\d+)__/g, (_, index) => tokens[Number(index)]);
}

function escapeHtml(value) {
    return value
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;');
}

function fileNameFromLink(link) {
    const pathname = new URL(link, window.location.href).pathname;
    return pathname.split('/').pop() || 'Java source';
}