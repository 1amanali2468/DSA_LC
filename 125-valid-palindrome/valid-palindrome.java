class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char left = s.charAt(i);
            char right = s.charAt(j);

            // skip non-alphanumeric from left
            if (!Character.isLetterOrDigit(left)) {
                i++;
                continue;
            }

            // skip non-alphanumeric from right
            if (!Character.isLetterOrDigit(right)) {
                j--;
                continue;
            }

            // compare after converting to lowercase
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}
