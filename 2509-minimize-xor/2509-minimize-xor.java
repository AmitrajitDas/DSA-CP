class Solution {
    private int countSetBits(int num) {
        int count = 0;
        while(num != 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }
    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }
    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }
    private int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }
    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int currSetBits = countSetBits(x);
        int reqSetBits = countSetBits(num2);

        if(currSetBits == reqSetBits) {
            return x;
        }
        
        int bit = 0;

        if(currSetBits < reqSetBits) {
            while(currSetBits < reqSetBits) {
                if(!isSet(x, bit)) {
                    x = setBit(x, bit);
                    currSetBits++;
                }
                bit++;
            }
        } else if(currSetBits > reqSetBits) {
            while(currSetBits > reqSetBits) {
                if(isSet(x, bit)) {
                    x = unsetBit(x, bit);
                    currSetBits--;
                }
                bit++;
            }
        }

        return x;
    }
}