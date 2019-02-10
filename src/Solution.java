import java.util.*;

public class Solution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length) {
                //if there is a deficit
                if (prices[i] > prices[i + 1]) {
                    continue;
                }
                if (prices[i] < prices[i + 1]) {
                    //buy and sell if you make a profit
                    sum += (prices[i + 1] - prices[i]);
                }
            } else {
                if (prices[i - 1] > prices[i]) {
                    continue;
                }
                if (prices[i - 1] < prices[i]) {
                    //buy and sell if you make a profit
                    sum += (prices[i] - prices[i - 1]);
                }
            }
        }
        return sum;
    }

    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {

            int temp = nums[nums.length - 1];
            int j;
            for (j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;

        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        //check 0
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        //check last index
        else if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }
        //check middle indices
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i - 1]) {
                continue;
            }
            return nums[i];
        }
        return 0;
    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
        } else {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = 0;

                if (i == 0) {
                    //were have a 9999 thingy, return +1
                    int ret[] = new int[digits.length + 1];
                    ret[0] = 1;
                    return ret;
                }

                if (digits[i - 1] != 9) {
                    digits[i - 1]++;
                    break;
                }
            }
        }
        return digits;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //nums = {2, 7, 11, 15}, target = 9
        //first digit is 2, so check if the hashmap contains the target - the digit
        //if it doesnt, add to hashmap and move to next index
        int comp;
        for (int i = 0; i < nums.length; i++) {
            comp = target - nums[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode prev = null;
        ListNode curr = null;
        int value = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //calculate value or next digit
            if (l1 == null) {
                value = l2.val;
            } else if (l2 == null) {
                value = l1.val;
            } else {
                value = l1.val + l2.val + carry;
            }
            //check if you need to carry a 1
            if (value >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            value = value % 10;
            //allocate new node to be the new value
            curr = new ListNode(value);
            //check if this is the head of the LL
            if (sum == null) {
                sum = curr;
            }
            //add new digit to LL
            else {
                prev.next = curr;
            }
            prev = curr;
            //advance LL pointers
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //check final digit
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return sum;
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (longest < hashSet.size()) {
                longest = hashSet.size();
            }
            hashSet.clear();
            for (int j = i; j < s.length(); j++) {
                if (hashSet.contains(s.charAt(j))) {
                    if (longest < hashSet.size()) {
                        longest = hashSet.size();
                    }
                    hashSet.clear();
                }
                hashSet.add(s.charAt(j));
            }
        }

        if (longest < hashSet.size()) {
            longest = hashSet.size();
        }

        return longest;
    }

    public String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return Character.toString(s.charAt(0));
            }
        }
        StringBuilder str;
        int length = 0;
        int start = 0, end = 0;
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            //use every index to check even and odd palindromes extending out from that index
            //check longest even palindrome for letter
            start = i - 1;
            end = i;
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end)) {
                    break;
                }
                int temp = s.substring(start, end + 1).length();
                if (temp > length) {
                    length = temp;
                    firstIndex = start;
                    secondIndex = end + 1;
                }
                start--;
                end++;
            }
            //check longest odd palindrome for letter
            start = i - 1;
            end = i + 1;
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end)) {
                    break;
                }
                int temp = s.substring(start, end + 1).length();
                if (temp > length) {
                    length = temp;
                    firstIndex = start;
                    secondIndex = end + 1;
                }
                start--;
                end++;
            }
        }
        if (firstIndex == 0 && secondIndex == 0) {
            return Character.toString(s.charAt(0));
        }
        return s.substring(firstIndex, secondIndex);
    }

    public int myAtoi(String str) {
        //positive, negative
        //numbers only
        //null string
        int pos = 0;
        double sum = 0;
        boolean foundNumber = false;
        if (str == null || str.equals("")) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                if (foundNumber) {
                    if (pos == 1) {
                        sum = sum * -1;
                    }
                    return (int) sum;
                }
                if (str.charAt(i) == '-') {
                    if (pos > 0) {
                        return 0;
                    }
                    pos = 1;
                    continue;
                } else if (str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
                    if (pos > 0) {
                        return 0;
                    }
                    continue;
                } else if (str.charAt(i) == '+') {
                    if (pos > 0) {
                        return 0;
                    } else {
                        pos = 2;
                        continue;
                    }
                } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    if (pos == 1) {
                        sum = sum * -1;
                    }
                    return (int) sum;
                } else {
                    if (sum == 0) {
                        continue;
                    }
                    if (pos == 1) {
                        sum = sum * -1;
                    }
                    return (int) sum;
                }
            }
            sum = sum * 10 + (str.charAt(i) - 48);
            foundNumber = true;
        }
        if (pos == 1) {
            sum = sum * -1;
        }
        return (int) sum;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        //edge cases
        if (nums.length == 3) {
            if (nums[0] + nums[1] + nums[2] == 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[0]);
                temp.add(nums[1]);
                temp.add(nums[2]);
                ret.add(temp);
                return ret;
            }
        }
        //fix one number
        //find two numbers that equal that equal -FixedNumber using start and end pointers, just like 2sum

        int start, end;
        for (int i = 0; i < nums.length; i++) {
            int fixedNum = nums[i];
            int sum = 0;
            start = i + 1;
            end = nums.length - 1;
            while (start < end) {
                sum = nums[start] + nums[end] + fixedNum;
                if (sum == 0) {
                    //found triplet
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[start]);
                    temp.add(fixedNum);
                    temp.add(nums[end]);
                    while (nums[start] == nums[start + 1]) {
                        start++;
                        if (start == end || start == nums.length) {
                            break;
                        }
                    }
                    while (nums[end] == nums[end - 1]) {
                        end--;
                        if (start == end || end == 0) {
                            break;
                        }
                    }
                    if (!ret.contains(temp)) {
                        ret.add(temp);
                        end--;
                        start++;
                    } else {
                        break;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ret;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Character, String> phoneNumbers = new HashMap<Character, String>() {{
            put('1', "");
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
            put('0', "");
        }};
        //conversion from char to 1-9 in ascii digits.charAt(0) - 49;
        //conversion from 1-9 to char in ascii

        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> preres = new ArrayList<>();
        res.add("");

        for (int i = 0; i < digits.length(); i++) {
            String letters = phoneNumbers.get(digits.charAt(i));
            if (letters.length() == 0)
                continue;
            for (String str : res) {
                for (int j = 0; j < letters.length(); j++)
                    preres.add(str + letters.charAt(j));
            }
            res = preres;
            preres = new ArrayList<>();
        }
        return res;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == '}') {
                if (stack.empty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp != '{') {
                    return false;
                }
            } else if (s.charAt(i) == ')') {
                if (stack.empty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp != '(') {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (stack.empty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp != '[') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ret = head;

        while (l1 != null || l2 != null) {
            //check which is smaller and set value
            //check if both are valid
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    ret.next = l1;
                    l1 = l1.next;
                } else {
                    ret.next = l2;
                    l2 = l2.next;
                }
            } else if (l2 == null) {
                //advance l1
                ret.next = l1;
                l1 = l1.next;
            } else {
                //advance l2
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }
        return head.next;
    }

    public List<List<Integer>> subsets(int[] nums) {
        /*
        Find all subsets in an integer array
        How to do: lets say there are 4 nums. Then 1111 represents all 4, 1101 represets 1,2,4 and so on
        Loop from 0->10000 (0->(1<<n))
        Keep adding one, if digit is one, add those 1s to the return list
        i = 1 = 00001 (adds only 1)
        i = 2 = 00010 (adds only 2)
        i = 3 = 00011 (adds 1 and 2)
        1 << j = 00001, 00010, 00100, 01000, 10000
         */

        if (nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) > 0) {
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (hashMap.containsKey(key)) {
                //add to the arraylist
                ArrayList<String> ret = hashMap.get(key);
                ret.add(strs[i]);
                hashMap.put(key, ret);
            } else {
                ArrayList<String> ret = new ArrayList<>();
                ret.add(strs[i]);
                hashMap.put(key, ret);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    public List<Integer> grayCode(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        //000
        //001
        //011
        //010
        //100
        //110
        int a = 0;
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        for (int i = 2; i < (1 << n); i = i << 1) {
            for (int j = i - 1; j >= 0; j--) {
                arrayList.add(arrayList.get(j));
            }
            for (int j = 0; j < i; j++) {
                arrayList.set(j, ('0' + arrayList.get(j) - 48));
            }
            int sub = 48;
            for (int j = i; j < 2 * i; j++) {
                if (a % 2 == 0) {
                    sub = sub - 1;
                    a = 0;
                }
                a++;
                System.out.println(sub);
                arrayList.set(j, ('1' + arrayList.get(j)) - sub);
            }
        }
        return arrayList;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, int max, int min){
        if(root == null){
            return true;
        }
        if (root.val > max || root.val < min){
            return false;
        }
        return (isValidBSTHelper(root.left, root.val-1, min) && isValidBSTHelper(root.right,max, root.val-1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> levelNodes = new ArrayList<>();
        Queue<TreeNode> current =new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()){
            TreeNode node = current.remove();
            if(node.right != null){
                next.add(node.right);
            }
            if(node.left != null){
                next.add(node.left);
            }
            levelNodes.add(node.val);
            if(current.isEmpty()){
                //move to next
                //reset all temp objects
                current = next;
                next = new LinkedList<>();
                ret.add(levelNodes);
                levelNodes = new ArrayList<>();
            }
        }
        return ret;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        /* Brute force
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if(temp > max){
                    max = temp;
                }
            }
        }
        */
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            else if(prices[i] - minPrice > max){
                max  = prices[i] - minPrice;
            }
        }
        return max;
    }

    class Word {
        String word;
        int length;

        Word(String word, int length){
            this.word = word;
            this.length = length;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(beginWord, 1));
        wordList.add(endWord);
        while (!queue.isEmpty()){
            Word top = queue.remove();
            String word = top.word;
            if (word.equals(endWord)){
                return top.length;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < beginWord.length(); i++) {
                for (char j = 'a'; j < 'z'; j++) {
                    char temp = arr[i];
                    if (arr[i] != j){
                        arr[i] = j;
                    }
                    String newWord = new String(arr);
                    if (wordList.contains(newWord)){
                        queue.add(new Word(newWord, top.length+1));
                        wordList.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        /*
        DP -> Boolen array stores true false such that if an index is true,
                a substring can be formed that is in the dictionary from i to that index
         */
        boolean[] dp = new boolean[s.length()];
        System.out.println(dp);
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]){
                for (int j = i; j < s.length(); j++) {
                    if (wordDict.contains(s.substring(i,j))){
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        if (head.next == null){
            return false;
        }
        ArrayList<ListNode> arrayList = new ArrayList<>();
        arrayList.add(head);
        head = head.next;
        while (head != null){
            if(arrayList.contains(head)){
                return true;
            }
            arrayList.add(head);
            head = head.next;
        }
        return false;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        if(headA == headB){
            return headA;
        }
        while (headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if(hashSet.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int diff;
        for (int i = 0; i < numbers.length; i++) {
            diff = target - numbers[i];
            if (hashMap.containsKey(diff)){
                return new int[]{hashMap.get(diff), i};
            }
            hashMap.put(numbers[i], i);
        }
        return new int[]{0};
    }

    public String reverseWords(String s) {
        if (s.length() < 1){
            return "";
        }
        StringBuilder ret = new StringBuilder();
        int j = s.length();
        for (int i = s.length()-1; i > 0; i--) {
            if (s.charAt(i) == ' '){
                String str = s.substring(i+1,j);
                if (str.equals("")){
                    j--;
                    continue;
                }
                ret.append(str);
                ret.append(' ');
                j = i;
            }
        }
        int i;
        for (i = 0; i < j; i++) {
            if (s.charAt(i) != ' '){
                break;
            }
        }
        String str = s.substring(i,j);
        ret.append(str);
        //remove whitespace from end
        StringBuilder f = new StringBuilder();
        i = ret.toString().length()-1;
        for (; i > 0; i--) {
            if (ret.toString().charAt(i) != ' '){
                break;
            }
        }
        f.append(ret.toString().substring(0,i+1));
        if (f.toString().equals(" ")){
            return "";
        }
        return f.toString();
    }

    public void printLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            //enqueue left
            if(temp.left != null){
                queue.add(temp.left);
            }
            //enqueue right
            if(temp.right != null){
                queue.add(temp.right);
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(i == 0){
                    arrayList.add(node.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
            }
        }
        return arrayList;
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int l1 = grid.length;
        int l2 = grid[0].length;
        boolean[][] marked = new boolean[l1][l2];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !marked[i][j]){
                    markIsland(marked, grid, i ,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void markIsland(boolean[][] marked, char[][] grid, int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || marked[i][j] || grid[i][j] == '0'){
            return;
        }
        marked[i][j] = true;
        markIsland(marked, grid, i+1,j);
        markIsland(marked, grid, i-1,j);
        markIsland(marked, grid, i,j+1);
        markIsland(marked, grid, i,j-1);
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n){
        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length -k];
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while (head != null){
            ListNode pop = stack.pop();
            if(pop.val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }
        TreeNode left =  lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        if(left == null){
            //inside right subtree
            return right;
        }
        return left;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        for (int i = nums.length -2; i >= 0 ; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            products[i] = right[i] * left[i];
        }
        return products;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if(i == matrix.length-1 || matrix[0].length == 1){
                //on last row
                for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
            else if(matrix[i][0] <= target && target <= matrix[i][matrix[0].length-1]){
                for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean searchMatrixn2(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = matrix.length-1;
        int j = 0;
        while (i >= 0  && j < matrix[0].length){
            if(target < matrix[i][j]){
                i--;
            }
            else if(target > matrix[i][j]){
                j++;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public boolean isAnagram1(String s, String t) {
        if(s.equals("") || t.equals("") || s.length() == 0 || t.length() == 0 || s.length() != t.length() || s.equals(t)){
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        for (int i = 0; i < charS.length; i++) {
            if(charS[i] != charT[i]){
                return false;
            }
        }
        return true;
    }


    public boolean isAnagramOn(String s, String t){
        if(s.equals("") || t.equals("") || s.length() == 0 || t.length() == 0 || s.length() != t.length()){
            if(s.equals(t)){
                return true;
            }
            return false;
        }
        int[] array1 = new int[256];
        int[] array2 = new int[256];
        Arrays.fill(array1,0);
        Arrays.fill(array2,0);
        for (int i = 0; i < s.length(); i++) {
            array1[s.charAt(i)]++;
            array2[t.charAt(i)]++;
        }
        for (int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{0};
        }
        int[] ret = new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            if(i + k > nums.length){
                break;
            }
            for (int j = 0; j < k; j++) {
                if(nums[i+j] > max){
                    ret[i] = nums[i+j];
                    max = nums[i+j];
                }
            }
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
        return ret;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        s.append(root.val + ",");
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.right == null && node.left == null){
                continue;
            }
            else if(node.left == null){
                s.append("null,");
                s.append(node.right.val  + ",");
                queue.add(node.right);
            }
            else if(node.right == null){
                s.append("null,");
                s.append(node.left.val  + ",");
                queue.add(node.left);
            }
            else {
                s.append(node.left.val + ",");
                s.append(node.right.val  + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return s.toString().substring(0,s.length());
    }

    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        while (data.length() > 0) {
            String currentData = data.substring(0, data.indexOf(','));
            TreeNode t;
            if(currentData.equals("null")){
                t = new TreeNode(Integer.MIN_VALUE);
            }
            else {
                t = new TreeNode(Integer.parseInt(currentData));
            }
            queue.add(t);
            data = data.substring(data.indexOf(',')+1);
        }
        TreeNode head = new TreeNode(queue.remove().val);
        buildTree(queue,head);
        return head;
    }

    public void buildTree(Queue<TreeNode> queue, TreeNode head){
        if(queue.isEmpty()){
            return;
        }
        TreeNode left = queue.remove();
        TreeNode right = queue.remove();
        if(left.val == Integer.MIN_VALUE && right.val == Integer.MIN_VALUE){
            head.left = null;
            head.right = null;
            return;
        }
        else if(left.val == Integer.MIN_VALUE){
            //dont build left
            head.right = right;
            head.left = null;
        }
        else if(right.val == Integer.MIN_VALUE){
            //dont build right
            head.left = left;
            head.right = null;
        }
        else {
            head.left = left;
            head.right = right;
            buildTree(queue, head.left);
            buildTree(queue, head.right);
        }
    }

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int max = 0;
        int min = 0;
        int left =0;
        int sum = 0;
        int right = height.length-1;
        while (left <= right){
            if (height[left] < height[right]){
                if(height[left] > min){
                    min = height[left];
                }
                else {
                    sum += min - height[left++];
                }
            }
            else {
                if(height[right] > max){
                    max = height[right];
                }
                else{
                    sum += max - height[right--];
                }
            }
        }
        return sum;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return checkSymmetry(root, root);
    }
    public boolean checkSymmetry(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null){
            return false;
        }
        else {
            if(root1.val != root2.val){
                return false;
            }
            return checkSymmetry(root1.left, root2.right) && checkSymmetry(root1.right, root2.left);
        }
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        else if(x == 0){
            return true;
        }
        int length = (int)(Math.log10(x)+1);
        if(length == 1){
            return true;
        }
        while (length != 1){
            length = (int)(Math.log10(x)+1);
            int left = x/(int) Math.pow(10, length-1);
            int right = x % 10;
            System.out.println(left + " " + right + " " + x);
            if(left != right){
                return false;
            }
            x = x/10 - (int) Math.pow(10,(int)(Math.log10(x)+1)-2)*left;
        }
        return true;
    }

    public String countAndSay(int n) {
        ///1 -> 11 -> 21 -> 1211 -> 111221
        if(n == 1){
            return "1";
        }
        else if(n == 2){
            return "11";
        }
        String str = "11";
        String temp = "";
        for (int i = 3; i <= n; i++) {
            str += '$';
            int count = 1;
            temp = "";
            char[] arr = str.toCharArray();
            for (int j = 1; j < str.length(); j++) {
                if(arr[j] != arr[j-1]){
                    temp += count;
                    temp += arr[j-1];
                    count = 1;
                }
                else {
                    count++;
                }
            }
            str = temp;
        }
        return str;
    }

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() -1;
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public String isAnagram(String str1, String str2){
        int[] a = new int[256];
        int[] b = new int[256];
        Arrays.fill(a,0);
        Arrays.fill(b,0);
        for (int i = 0; i < str1.length(); i++) {
            a[str1.charAt(i)]++;
            b[str1.charAt(i)]++;
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]){
                return "Not Anagrams";
            }
        }
        return "Anagrams";
    }

    public void StringTokens(String str){
        if(str.length() < 1 || str.length() > 40000){
            return;
        }
        String[] arr = str.split("[<>%\\$'?!., ]");
        int count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("")|| arr[i].equals(" ")){
                count--;
            }
        }
        System.out.println(count);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("") || arr[i].equals(" ")){
                continue;
            }
            System.out.println(arr[i]);
        }
    }

    /*
    Find root to leaf combo in a tree that sums up to a certain number
     */

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        return hasPathSumHelper(root, sum, 0);
    }

    public boolean hasPathSumHelper(TreeNode root, int sum, int curr){
        curr+=root.val;
        if(curr == sum){
            if(root.left == null && root.right == null){
                return true;
            }
        }
        if(root.left != null){
            if(hasPathSumHelper(root.left, sum, curr)){
                return true;
            }
        }
        if(root.right != null){
            if(hasPathSumHelper(root.right, sum, curr)) {
                return true;
            }
        }
        return false;
    }

    /*
    Find all root to leaf paths in a tree that sum to a number
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        pathSum2Helper(root, sum,  currentList, ret);
        return ret;
    }

    public void pathSum2Helper(TreeNode root, int sum, List<Integer> currentList, List<List<Integer>> ret){
        if(root == null || sum-root.val < 0){
            return;
        }
        currentList.add(root.val);
        if(sum == root.val && root.left == null && root.right == null){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(currentList);
            ret.add(temp);
        }
        pathSum2Helper(root.left, sum-root.val, currentList, ret);
        pathSum2Helper(root.right, sum-root.val, currentList, ret);
        currentList.remove(currentList.size()-1);
    }

    public int minPathSum(int[][] grid) {
        int sum = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        //initialize top and left sides
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public int min(int a, int b){
        if(a < b){
            return a;
        }
        return b;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        //case 1: there are an odd numbers, index of med = (l1+l2)/2
        //case 2: there are even numbers, index of med = average( (l1+l2)-1 and (l1+l2)+1)
        if((l1+l2)%2 != 0){
            //even
            double med = 0;
            for (int i = 0; i < (1+(l1+l2)/2); i++) {
                if(index1 != l1 && index2 != l2){
                    if(nums1[index1] < nums2[index2]){
                        med = nums1[index1++];
                    }
                    else{
                        med = nums2[index2++];
                    }
                }
                else if(index1 < l1){
                    med = nums1[index1++];
                }
                else {
                    med = nums2[index2++];
                }
            }
            return med;
        }
        else {
            //odd
            double med1 = 0;
            double med2 = 0;
            for (int i = 0; i < (1+(l1+l2)/2); i++) {
                med2 = med1;
                if(index1 != l1 && index2 != l2){
                    if(nums1[index1] < nums2[index2]){
                        med1 = nums1[index1++];
                    }
                    else{
                        med1 = nums2[index2++];
                    }
                }
                else if(index1 < l1){
                    med1 = nums1[index1++];
                }
                else {
                    med1 = nums2[index2++];
                }
            }
            return (med1+  med2)/2;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = " ";
        int[] input1 = new int[]{1,2};
//        int[][] input = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int[] input2 = new int[]{-1,3};
//        char[][] input = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 10;

//        TreeNode node = new Solution.TreeNode(5);
//        node.left = new Solution.TreeNode(4);
//        node.right = new Solution.TreeNode(8);
//        node.left.left = new Solution.TreeNode(11);
//        node.left.left.left = new Solution.TreeNode(7);
//        node.left.left.right = new Solution.TreeNode(2);
//        node.right.left = new Solution.TreeNode(13);
//        node.right.right = new Solution.TreeNode(4);
//        node.right.right.left = new Solution.TreeNode(5);
//        node.right.right.right = new Solution.TreeNode(1);

//        ListNode node = new ListNode(3);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
        System.out.println(s.findMedianSortedArrays(input1, input2));
//        String d = s.serialize(node);
//        s.deserialize(d);
    }
}
