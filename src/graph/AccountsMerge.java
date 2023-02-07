package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Problem link :
 * https://leetcode.com/problems/accounts-merge/
 * https://practice.geeksforgeeks.org/problems/merging-details/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=FMwpt_aQOGw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=50
 * 
 * https://takeuforward.org/data-structure/accounts-merge-dsu-g-50/
 * 
 */
public class AccountsMerge {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		List<List<String>> accounts = new ArrayList<>();
		accounts.add(new ArrayList<>(List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co")));
		accounts.add(new ArrayList<>(List.of("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co")));
		accounts.add(new ArrayList<>(List.of("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co")));
		accounts.add(new ArrayList<>(List.of("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co")));
		accounts.add(new ArrayList<>(List.of("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")));

		int n = accounts.size();

		int[] parent = new int[n];
		int[] rank = new int[n];
		for (int i = 0; i < n; i++) {
			rank[i] = 0;
			parent[i] = i;
		}

		Map<String, Integer> map = new HashMap<>();
		for (int k = 0; k < accounts.size(); k++) {
			List<String> mailList = accounts.get(k);
			for (int i = 1; i < mailList.size(); i++) {
				String mail = mailList.get(i);
				if (!map.containsKey(mail)) {
					map.put(mail, k);
				} else {
					int parentNode = map.get(mail);
					union(parent, rank, parentNode, k);
				}
			}
		}
		List<String>[] mergedAccounts = new List[n];
		for (Entry<String, Integer> entry : map.entrySet()) {
			String mail = entry.getKey();
			int id = entry.getValue();
			int parentId = find(parent, id);
			if (mergedAccounts[parentId] == null) {
				mergedAccounts[parentId] = new ArrayList<>();
			}
			mergedAccounts[parentId].add(mail);
		}
		List<List<String>> answer = new ArrayList<>();
		for (List<String> account : mergedAccounts) {
			if (account == null)
				continue;
			Collections.sort(account);
			int id = find(parent,map.get(account.get(0)));
			String name = accounts.get(id).get(0);
			account.add(0, name);
			answer.add(account);
		}
		System.out.println(answer);
	}

	private static void union(int[] parent, int[] rank, int u, int v) {
		int baseParentU = find(parent, u);
		int baseParentV = find(parent, v);
		if (rank[baseParentU] < rank[baseParentV]) {
			parent[baseParentU] = baseParentV;
			rank[baseParentV]++;
		} else {
			parent[baseParentV] = baseParentU;
			rank[baseParentU]++;
		}
	}

	private static int find(int[] parent, int node) {
		// src == parent[src] means parent of the node
		if (node == parent[node])
			return node;
		int baseParent = find(parent, parent[node]);
		parent[node] = baseParent;
		return baseParent;
	}
}
