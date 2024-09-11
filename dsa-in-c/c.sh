#!/bin/bash

# Check if the user provided a relative C file path
if [ "$#" -lt 1 ]; then
    echo "Usage: $0 <relative_path_to_c_file> [-e]"
    exit 1
fi

# Get the relative path to the C file
C_FILE="$1"

# Check if the provided file exists and is a C file
if [ ! -f "$C_FILE" ] || [[ "$C_FILE" != *.c ]]; then
    echo "Error: File does not exist or is not a C file."
    exit 1
fi

# Check for the -e flag
RUN_EXECUTABLE=false
if [ "$#" -eq 2 ] && [ "$2" == "-e" ]; then
    RUN_EXECUTABLE=true
fi

# Get the directory of the C file and the base name (without extension)
DIR_NAME=$(dirname "$C_FILE")
BASE_NAME=$(basename "$C_FILE" .c)

# Create the output directory structure
OUTPUT_DIR="out/$DIR_NAME"
mkdir -p "$OUTPUT_DIR"

# Compile the C file and place the output in the corresponding out directory
gcc "$C_FILE" -o "$OUTPUT_DIR/$BASE_NAME"

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compiled $C_FILE to $OUTPUT_DIR/$BASE_NAME"

    # Run the executable if the -e flag was provided
    if [ "$RUN_EXECUTABLE" = true ]; then
        echo "Running the executable..."
        "$OUTPUT_DIR/$BASE_NAME"
    fi
else
    echo "Compilation failed."
    exit 1
fi