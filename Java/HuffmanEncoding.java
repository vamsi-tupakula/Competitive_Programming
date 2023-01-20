package Java;

import java.util.*;

class HuffmanEncoding {
    private static void buildFreqTable(String str, Map<Character, Integer> freqTable) {
        for(char c : str.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0) + 1);
        }
    }

    private static void buildPriorityQueue(PriorityQueue<HuffNode> queue, Map<Character, Integer> freqTable) {
        for(Map.Entry<Character, Integer> entry : freqTable.entrySet()) {
            queue.add(new HuffNode(entry.getKey(), entry.getValue(), null, null));
        }

        while(queue.size() > 1) {
            HuffNode left = queue.poll();
            HuffNode right = queue.poll();
            HuffNode parent = new HuffNode('\0', left.freq + right.freq, left, right);
            queue.add(parent);
        }
    }

    private static void buildCodeTable(HuffNode node, String code, Map<Character, String> codeTable) {
        if(node.left == null && node.right == null) {
            codeTable.put(node.c, code);
            return;
        }
        buildCodeTable(node.left, code + "0", codeTable);
        buildCodeTable(node.right, code + "1", codeTable);
    }

    public static void main(String[] args) {
        String str = "ABCABAABCABDBADDCD";

        // storing characters in a hashmap
        Map<Character, Integer> freqTable = new HashMap<>();
        buildFreqTable(str, freqTable);

        // building a priority queue
        PriorityQueue<HuffNode> queue = new PriorityQueue<>((HuffNode nodeOne, HuffNode nodeTwo) -> {return nodeOne.freq - nodeTwo.freq;});
        buildPriorityQueue(queue, freqTable);

        // building code table
        Map<Character, String> codeTable = new HashMap<>();
        buildCodeTable(queue.poll(), "", codeTable);

        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            sb.append(codeTable.get(ch));
        }
        System.out.println("String : " + str);
        System.out.println("Huffman Code : " + sb);
    }
}

class HuffNode {
    char c;
    int freq;
    HuffNode left;
    HuffNode right;

    public HuffNode(char c, int freq, HuffNode left, HuffNode right) {
        this.c = c;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}