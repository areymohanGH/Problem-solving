import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class EasyProblems {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int ans = target - nums[i];
            if (visitedNumbers.containsKey(ans)) {
                return new int[] { i, visitedNumbers.get(ans) };
            }
            visitedNumbers.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    public int maxProfit(int[] prices) {
        int leastStockPrice = Integer.MAX_VALUE;
        int profitIfSoldThatDay = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            leastStockPrice = prices[i] < leastStockPrice ? prices[i] : leastStockPrice;
            profitIfSoldThatDay = prices[i] - leastStockPrice;
            maxProfit = Math.max(maxProfit, profitIfSoldThatDay);
        }
        return maxProfit;
    }

    public int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                result++;
            n = n >> 1;
        }
        return result;
    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int tSum = n * (n + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return tSum - sum;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((n & 1) == 1)
                result++;
            n = n >> 1;
        }
        return result;
    }

    public int climbStairs(int n) {
        int onestep = 1;
        int twostep = 0;
        int currstep = 1;
        for (int i = 0; i < n; i++) {
            currstep = onestep + twostep;
            twostep = onestep;
            onestep = currstep;
        }
        return currstep;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return temp.next;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int a : count) {
            if (a != 0)
                return false;
        }
        return true;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)))
                sb.append(Character.toLowerCase(s.charAt(i)));
        }
        return sb.toString().equals(sb.reverse().toString());
    }
}
