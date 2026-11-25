package lw06.Unguided;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        ArrayList<Integer> numbers = new ArrayList<>();
        while(read.hasNextLine()){
            numbers.add(read.nextInt());
        }
        int target = numbers .get(numbers.size() - 1);
        for (int i = 0; i < numbers.size() - 1; i++) {
            binarySearchTree.insert(numbers.get(i));
        }
        System.out.print("Preorder : ");
        binarySearchTree.preOrder();

        System.out.print("Inorder : ");
        binarySearchTree.inOrder();

        System.out.print("Postorder : ");
        binarySearchTree.postOrder();

        System.out.println("Search " + target + " : " + binarySearchTree.search(target));
        System.out.println("Nodes : " + binarySearchTree.countNodes());
        System.out.println("Leaves : " + binarySearchTree.countLeaves());

        read.close();
    }
}