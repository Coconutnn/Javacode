/*给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
如果可以构成，返回 true ；否则返回 false。
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] box = new int[26];
        for(char c:magazine.toCharArray())
            box[c-'a']++;
        for(char c : ransomNote.toCharArray())
            if(box[c-'a']--==0)
            return false;
        return true;
    }
}