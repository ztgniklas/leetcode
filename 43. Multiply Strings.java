class Solution {
    public String multiply(String num1, String num2) {
        String sum = "0";
        if ("0".equals(num1) || "0".equals(num2)) {
            return sum;
        }
        for (int i = num2.length() - 1; i >= 0; i--) {
            String tmp = mul1Dig(num1, num2.substring(i, i + 1));
            for (int j = 0; j < num2.length() - i - 1; j++) {
                tmp = tmp.concat("0");
            }
            sum = add1Dig(sum, tmp);
        }
        return sum;
    }
    
    private String mul1Dig(String num1, String digStr) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int dig = Integer.parseInt(digStr);
        for (int i = num1.length() - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(num1.substring(i, i + 1));
            tmp = tmp * dig + carry;
            sb.insert(0, tmp % 10);
            carry = tmp / 10;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
    
    private String add1Dig(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int dig1 = Integer.parseInt(num1.substring(i, i + 1));
            int dig2 = Integer.parseInt(num2.substring(j, j + 1));
            int tmp = dig1 + dig2 + carry;
            carry = tmp / 10;
            sb.insert(0, tmp % 10);
            i--;
            j--;
        }
        
        while (i >= 0) {
            int dig1 = Integer.parseInt(num1.substring(i, i + 1));
            int tmp = dig1 + carry;
            carry = tmp / 10;
            sb.insert(0, tmp % 10);
            i--;
        }
        
        while (j >= 0) {
            int dig2 = Integer.parseInt(num2.substring(j, j + 1));
            int tmp = dig2 + carry;
            carry = tmp / 10;
            sb.insert(0, tmp % 10);
            j--;
        }
        if (carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}