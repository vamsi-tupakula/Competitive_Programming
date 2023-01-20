package Java;

import java.util.*;

public class HuffmanEncoding {
    public static void main(String[] args) {
        String input = "vamsikrishna";

        // Build frequency table
        Map<Character, Integer> freqTable = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0) + 1);
        }

        for(char ch : freqTable.keySet()) {
            System.out.println(ch + " " + freqTable.get(ch));
        }

        // Build Huffman tree
        PriorityQueue<Node> queue = new PriorityQueue<>((l, r) -> l.freq - r.freq); // max heap
        for (Map.Entry<Character, Integer> entry : freqTable.entrySet()) {
            queue.offer(new Node(entry.getKey(), entry.getValue(), null, null));
        }
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            queue.offer(parent);
        }

        // Build code table
        Map<Character, String> codeTable = new HashMap<>();
        buildCodeTable(queue.poll(), "", codeTable);

        // Encode input
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            encoded.append(codeTable.get(c));
        }
        System.out.println(encoded);
    }

    private static void buildCodeTable(Node node, String code, Map<Character, String> codeTable) {
        if (node.left == null && node.right == null) {
            codeTable.put(node.c, code);
            return;
        }
        buildCodeTable(node.left, code + '0', codeTable);
        buildCodeTable(node.right, code + '1', codeTable);
    }

    private static class Node {
        char c;
        int freq;
        Node left;
        Node right;

        Node(char c, int freq, Node left, Node right) {
            this.c = c;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }
}

