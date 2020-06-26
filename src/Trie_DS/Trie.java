package Trie_DS;
import myNode.TrieNode;

import java.util.Scanner;

public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)){
                node = node.get(curLetter);
            }
            else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String prefix){
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Trie object = new Trie();

        System.out.println("Enter the number string you want to add");
        int n = scan.nextInt();
        System.out.println("Enter "+n+" strings");
        while (n-- != 0) {
            String str = scan.next();
            object.insert(str);
        }

        System.out.println("enter the string you want to search");
        String str = scan.next();
        boolean ans = object.search(str);
        if (ans){
            System.out.println("Searched string found");
        }
        else{
            System.out.println("Search string is not present");
        }
    }
}
