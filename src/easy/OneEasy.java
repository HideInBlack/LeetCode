package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020年2月16日12:47:35
 * LeetCode
 * 简单模块     第一部分
 */

//单链表的结构体
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 //二叉树的结构体
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



public class OneEasy {

    /** 2022年3月15日00:30:45
     * main测试主函数
     */
    public static void main(String[] args) {
        OneEasy oneEasy = new OneEasy();
        System.out.println(oneEasy.getC(4,2));
        System.out.println(oneEasy.getCa(4,2));

    }

    /**  （数组里面的最大差值！！！）
     * 121. 买卖股票的最佳时机(dzy受启示写出)
     * 思路：1.记录今天之前的最小值
     *      2.计算今天卖出相对今天之前的最小值，然后比较谁更大
     * 关键就是：要记录今天之前的最小值，这个就是可以一遍遍历即可！
     * 它是以天为单位往前找，而不是以天为单位往后找，这样只需要记录最小的一天！
     *
     * 关键：因为每一天卖出，肯定都是与前面的最小值一天的差最大！
     */
    public int maxProfit1(int[] prices) {

        int max = 0; //最大差值
        int min = prices[0] ;//最小的一天
        for (int i = 1 ; i < prices.length ; i++){
            if (prices[i]<=min){//如果此个是最小值,就复制给最小值
                min = prices[i];
            }else {//如果不是最小值，就比较一下差值，看谁大
                if (prices[i]-min > max){
                    max = prices[i] -min;
                }
            }
        }
        return max;
    }

    /**
     * 121. 买卖股票的最佳时机(dzy 暴力解法失败，200/211 通过了)
     */
    public int maxProfit(int[] prices) {//0:40-0:52
        int max = 0;
        for (int i = 0 ; i < prices.length - 1; i++){
            int temp = 0;
            for (int j = i+1 ;j <prices.length ; j++){
                if (prices[i] < prices[j]){//只有价格高的那天才卖
                    if (prices[j]-prices[i]>temp){
                        temp = prices[j]-prices[i];
                    }
                }
            }
            if (max<temp){
                max = temp;
            }
        }
        return max;
    }

    /**
     * 119. 杨辉三角 II(新方法一定要会！，董政宇自己写出)
     * 最关键的地方在于：第i项是第i-1项的(rowIndex-i+1)/i 倍！
     * 返回「杨辉三角」的第 rowIndex 行
     */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long result = 1;
        //先把第一个加上
        list.add((int) result);
        for (int i = 1 ; i <= rowIndex ; i++){
            //从第二个开始加上
            result = result * (rowIndex-i+1)/i;
            list.add((int) result);
        }

        return list;
    }

    /**
     * again!
     * 新学到的一个求C(n,m)方法
     * 则第m 项= 第m-1项*(n-m+1)/m ;(从第0项开始的)
     */
    public long getCa(int n , int m){
        long result = 1;
        for (int i = 1; i <= m ; i++){
            result = result * (n-i+1)/i;
        }
        return result;
    }

    /**
     * 119. 杨辉三角 II（dzy自创失败）
     * 此方法能力有限只能满足到29！
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j <= rowIndex/2; j++){
            result.add((int) getC(rowIndex,j));
        }
//        if (rowIndex%2 == 0 ){//如果i是偶数，则剩一个复制(除了最后一个不要，其余从后往复制)
//            for (int k = result.size()-2 ;k >=0 ;k--){
//                result.add(result.get(k));
//            }
//        }else{//如果i是奇数，则完全复制
//            for (int k = result.size()-1 ;k >=0 ;k--){
//                result.add(result.get(k));
//            }
//        }
        return result;
    }

    /**
     * 118. 杨辉三角（dzy完全自创）
     * 中间List<List<Integer>> resultOut = new ArrayList<>();的使用值得再次品味
     * 并且关于C30 25这样的越界问题，可以转化为求C30 5的问题，因为他们是相等的！
     * 注意点：我的主要思路在杨辉三角中找到求概率Cn m的规律！
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultOut = new ArrayList<>();
        List<Integer> resultIn;

        for (int i = 0; i< numRows ;i++){
            resultIn = new ArrayList<>();
            for (int j = 0; j <= i/2; j++){
                resultIn.add((int) getC(i,j));
            }
            if (i%2 == 0 ){//如果i是偶数，则剩一个复制(除了最后一个不要，其余从后往复制)
                for (int k = resultIn.size()-2 ;k >=0 ;k--){
                    resultIn.add(resultIn.get(k));
                }
            }else{//如果i是奇数，则完全复制
                for (int k = resultIn.size()-1 ;k >=0 ;k--){
                    resultIn.add(resultIn.get(k));
                }
            }
            resultOut.add(resultIn);
        }


        return resultOut;
    }
    //写一个方法可以求Cn m这样的方法 例如C10 1= 10
    public long getC(int n , int m){
        int k ;int h;
        long tempn = 1;
        long tempm = 1;
        for ( k= n; k > n-m ;k--){//
            tempn = tempn * k;
        }
        for (h=1 ; h <= m ;h++){//
            tempm = tempm * h;
        }
         return (int)(tempn/tempm);
    }



    /**
     *100. 相同的树（dzy完全自创）
     * 用的递归算法的后序遍历；且一定要注意if语句的特殊情况！！！
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null){
            //采用后序遍历
            boolean key ;
            if (p.val == q.val){
                key = true;
            }else {
                key =false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && key ;
        }else if (p == null && q == null){//两个都为空
            return true;
        }else {//一个为空
            return false;
        }
    }
    /**
     * 94. 二叉树的中序遍历（dzy完全自创）
     * 注意点：对list的初始化：List<Integer> list = new ArrayList<>();
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        //这里要注意！我不会对list的初始化！！！
        List<Integer> list = new ArrayList<>();
        midVisist(root ,list);
        return list;
    }
    //定义的一个递归函数，来解决二叉树的遍历是十分的简单！
    public void midVisist(TreeNode root,List<Integer> list){
        if (root != null){
            midVisist(root.left , list);
            list.add(root.val);
            midVisist(root.right , list);
        }
    }

    /**
     * 88. 合并两个有序数组（知道思路，DZY自己原创）
     * 受启示后的思路：对于nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 nums1后面都是0
     * 则想到从后往前比较，则不需要辅助空间了！
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {//22：10
            int mLenth = m-1;
            int nLenth = n-1;
            int resultLen = m + n - 1 ;
            while (mLenth >= 0 && nLenth >= 0){
                if (nums1[mLenth] < nums2[nLenth]){
                    //这个时候的思路是从后往前插入，这就是谁大插入谁了
                    nums1[resultLen] = nums2[nLenth];
                    nLenth--;
                }else{
                    nums1[resultLen] = nums1[mLenth];
                    mLenth--;
                }
                resultLen--;
            }
            //此时是不管mlenth就算不等于0，也本身就在此数组中，无需在做什么！
            //所以这里只需要如果nums2没比较完的，全部复制给nums1即可！
            while (nLenth>=0){
                nums1[resultLen] = nums2[nLenth];
                nLenth--;
                resultLen--;
            }
    }

    /**
     * 88. 合并两个有序数组（dzy完全自创）
     * 题目要求：把2插入到1中，我反而用再创建一个数组，最后再复制进去通过请求了！所以一定要试试！
     */
    public void mergeDzy(int[] nums1, int m, int[] nums2, int n) {//22：35-23:00(任务内)


        int[] temp = new int[m+n];
        int i =0; int j = 0; int lenth = 0;
        while (i<m && j<n){
            if (nums1[i]<nums2[j]){
                //谁小就插谁
                temp[lenth] = nums1[i];
                i++;

            }else{
                temp[lenth] = nums2[j];
                j++;
            }
            lenth++;
        }
        if (j<n){//如果nums1搞完了，就把其余的都复制到其中
            while (j<n){
                temp[lenth] = nums2[j];
                j++;
                lenth++;
            }
        }else if (i<m){
            while (i<m){
                temp[lenth] = nums1[i];
                i++;
                lenth++;
            }
        }
        for (int k = 0 ; k< m+n; k++){
            nums1[k] = temp[k];
        }
    }

    /**
     * 83. 删除排序链表中的重复元素（dzy完全自创）
     */
    public ListNode deleteDuplicates(ListNode head) {//22:10-22:30
        ListNode headResult = head; //一定要想到用头结点 返回！
        if (head == null){ return null;}//这种特殊的情况要考虑到
        while (head.next != null){

            if (head.val == head.next.val){
                if (head.next.next == null){
                    //最后两个相等
                    head.next = null;
                }else {
                    //其他
                    head.next = head.next.next ;
                }
            }else{
                head = head.next;
            }

        }


        return headResult;
    }

    /**
     * 70. 爬楼梯(答案)
     * 用动态规划解决！
     * 到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法 因为n-1需要迈一个1阶，n-2需要迈一个2阶！！！
     */
    public int climbStairs(int n) {
        if ( n == 1){ return 1;}
        if ( n == 2){ return 2;}
        int a=1 ; int b=2; int sum = 0;
        for (int i = 3 ; i <= n; i++){
            sum = a + b;
            //更新下一次循环的a,b
            a = b;
            b = sum;
        }
        return sum;
    }

    /**
     * 70. 爬楼梯(失败) 只能解决38以内
     * 我知道此方法错在哪里了：想到用数学概率C（i,i+j）固然不错，但是当他们相乘的时候得到的数无法用int，long表示，只能越界
     * 所以此题真正的解法应该是动态规划！
     */
    public int climbStairsDzy(int n) {//23：20
        int count = 0;
        for (int i = 0 ; i <= n ; i++ ){
            for (int j = 0 ; j <= n ; j++){
                if ( i * 1 + j * 2 == n){
                    if (i == 0 || j == 0) {
                        count++;
                    }else{
                        long temp1 = 1;
                        long temp2 = 1;
                        int k ;int h;
                        //假如j=4，i=6就是求一个C10 4的一个过程
                        for ( k= i+j ; k > i ;k--){//7* -10
                            temp1 = temp1 * k;
                        }
                        for (h=1 ; h <= j ;h++){//1* - 4
                            temp2 = temp2 * h;
                        }
                        count = count + (int)(temp1/temp2);
                    }

                    break;
                }
            }
        }
        return count;
    }


    /**
     * 南邮真题？
     * 输出: -一个正整数，表示大于正整数n的最小质数和最小合数之和。
     * 质数是指在大于l的自然数中。除了1和它本身以外不再有其他因数的自然数。
     * 合数是指在大于1的整数中除了能被1和本身整除外。还能被其他数(0除外)整除的数。
     * 关键 ： 除1以外的正整数，不是质数就是合数！
     */
    public int minMaxSum(int n){
        int minZ = -1;
        int minH = -1;
        for(int i = n + 1 ;  ; i++){
            int count = 0;
            for (int j = 2 ; j < i; j++){
                if (i%j == 0){//如果=0 表明此数是合数
                    if (minH == -1){
                        minH = i;
                        break;
                    }else{
                        //已有最小合数，直接中断
                        break;
                    }
                }else{//count + 到一整圈则表示是质数
                    count++;
                }
            }
            //如果此数转了一圈都是没有因数，则表明此数是质数；
            if (minZ == -1 && count==i-2){
                minZ = i;
            }
            //如果最小质数和最小合数都找到的时候就跳出循环！
            if (minH != -1 && minZ != -1){
                break;
            }
        }
        System.out.println("最小质数：" + minZ);
        System.out.println("最小合数：" + minH);
        return minH + minZ;
    }

    /**
     * 69. x 的平方根(学到二分查找思路后才自创)
     * 注意点 1.要想到此题是二分查找思路
     *        2.对于乘可能会越界，mid*mid == x 要改成除法 mid = x/mid!
     *        3.而且最后取整是往小的取，所以返回的是j，因为此时的j是小的，是在左边的！
     */
    public int mySqrt(int x) {//22:40 -23.13
        //二分查找思路
        int i = 0 ;
        int j = x ;
        int mid ;
        if (x == 0){return  0; }
        if (x == 1){return  1; }
        while (i <= j){
            mid = (i + j) / 2;
            if (mid  == x/mid ){
                return mid;
            }else if (mid  < x/mid){
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return j;//因为取整j是在左边的！
    }

    /**
     * 67. 二进制求和（dzy完全自创）
     * 模拟进位，但是做的有点儿小麻烦
     */
    public String addBinary(String a, String b) {
        int aLenth = a.length();
        int bLenth = b.length();
        String result = "";
        //谁的长度小，以谁为循环
        if (aLenth<=bLenth){//a的字符串长度小
            int temp = 0;//temp表示的是进位

            for (int i =0 ; i <aLenth ; i++){
                //其实主要是三种情况（1）.都为0 ；（2）.都为1 ；（3）.一个为0一个为1
                if (a.charAt(aLenth-i-1) == b.charAt(bLenth-i-1) && b.charAt(bLenth-i-1) == '0'){
                    //（1）如果两个都为0
                    result = temp + result;
                    temp = 0;
                }else if(a.charAt(aLenth-i-1) == b.charAt(bLenth-i-1) && b.charAt(bLenth-i-1) == '1'){
                    //（2）如果两个都为1
                    result = temp + result ;
                    temp = 1;
                }else{
                    //（3）此时是一个为1，一个为0
                    if (temp==0){
                        result = 1 + result;
                        temp = 0;
                    }else {
                        result = 0 + result ;
                        temp = 1;
                    }
                }
            }
            //再根据剩余长度
            if (temp==0 ){//进位为0，直接加上即可
                for (int i = bLenth-aLenth-1 ; i>=0 ;i--){
                    result = b.charAt(i) + result ;
                }
            }else{
                for (int i = bLenth-aLenth-1 ; i>=0 ;i--){
                    if (b.charAt(i) == '1' && temp == 1){
                        result = 0 + result ;
                        temp = 1;
                    }else if (b.charAt(i) == '0' && temp == 0 ){
                        result = 0 + result;
                        temp = 0;
                    }else {
                        result = 1 + result;
                        temp = 0;
                    }
                }
                if (temp == 1){
                    result = 1 + result ;
                }
            }
            return result;

        }else{//b的长度小
            int temp = 0;//temp表示的是进位

            for (int i =0 ; i <bLenth ; i++){
                //其实主要是三种情况（1）.都为0 ；（2）.都为1 ；（3）.一个为0一个为1
                if (a.charAt(aLenth-i-1) == b.charAt(bLenth-i-1) && b.charAt(bLenth-i-1) == '0'){
                    //（1）如果两个都为0
                    result = temp + result;
                    temp = 0;
                }else if(a.charAt(aLenth-i-1) == b.charAt(bLenth-i-1) && b.charAt(bLenth-i-1) == '1'){
                    //（2）如果两个都为1
                    result = temp + result ;
                    temp = 1;
                }else{
                    //（3）此时是一个为1，一个为0
                    if (temp==0){
                        result = 1 + result;
                        temp = 0;
                    }else {
                        result = 0 + result ;
                        temp = 1;
                    }
                }
            }
            //再根据剩余长度
            if (temp==0 ){//进位为0，直接加上即可
                for (int i = aLenth-bLenth-1 ; i>=0 ;i--){
                    result = a.charAt(i) + result ;
                }
            }else{
                for (int i = aLenth-bLenth-1 ; i>=0 ;i--){

                    if (a.charAt(i) == '1' && temp == 1){
                        result = 0 + result ;
                        System.out.println(result);
                        temp = 1;
                    }else if (a.charAt(i) == '0' && temp == 0 ){
                        result = 0 + result;
                        temp = 0;
                    }else {
                        result = 1 + result;
                        temp = 0;
                    }
                }
                if (temp == 1){
                    result = 1 + result ;
                }
            }
            return result;

        }

    }

    /**
     * 66. 加一（dzy完全自创）
     */
    public int[] plusOne(int[] digits){
        int arrayLenth = digits.length;
        //特殊情况1.数组最后一个数是9
        if (digits[arrayLenth-1] == 9){
            //如果全是9
            int count = 0;
            for (int i = arrayLenth-1 ; i >=0 ; i--){//计数：从后往前共有几个9
                if (digits[i] == 9){
                    count++;
                }else{
                    break;
                }
            }
            if (count == arrayLenth){ //如果全是9
                int[] newArray = new int[arrayLenth+1];
                for (int i = 0 ; i < arrayLenth ; i++){
                    newArray[i] = 0;
                }
                newArray[0] = 1;
                return newArray;
            }else{//只有一些9

                for (int i = arrayLenth - count ; i < arrayLenth ; i++){
                    digits[i] = 0;
                }
                digits[arrayLenth - count-1] = digits[arrayLenth - count-1] +1;
                return digits;
            }
        }else {
            digits[arrayLenth-1] = digits[arrayLenth-1] + 1 ;
            return digits;
        }

    }

    /**
     * 58. 最后一个单词的长度（dzy完全自创）
     */
    public int lengthOfLastWord(String s) {

        int wordLenth = 0;
        //两种情况 最后一个字符是空和不是空
        if(s.charAt(s.length() - 1) == ' '){//是空

            int key = 0;
            for (int i = s.length()-1 ; i >= 0; i--){
                if (s.charAt(i) != ' '){
                  //先找到第一个不是空的位置
                    key = i;
                    break;
                }
            }
            //开始计算长度
            for (int i = key ; i >= 0; i--){
                if (s.charAt(i) == ' '){
                    return wordLenth;
                }else {
                    wordLenth++;
                }
            }
        }else{//不是空
            for (int i = s.length()-1 ; i >= 0; i--){
                if (s.charAt(i) == ' '){
                    return wordLenth;
                }else {
                    wordLenth++;
                }
            }
        }
        return wordLenth;

    }

    /**
     * 53. 最大子数组和（难，暂不做）
     */

    /**
     * 35. 搜索插入位置（dzy完全自创）
     * 此题是二分查找法！下面几个标注的细节别忘记！
     */
    public int searchInsert(int[] nums, int target) {
        //这一题应该是二分查找
        int i = 0;
        int j = nums.length-1;
        int mid;
        while (i <= j){  //这里等于号千万别忘记
            mid = (i + j ) / 2;
            if (target < nums[mid]){
                j = mid-1;//这里要减1
            }else if(target > nums[mid]){
                i = mid+1;//这里要加1
            }else {
                return mid;
            }
        }
        return i;
    }

    /**
     * 28. 实现 strStr() （dzy完全自创）
     * 要注意几个特殊的情况，空字符串和长度越界等！
     */
    public int strStr(String haystack, String needle) {

        int bLenth = needle.length();
        if (bLenth == 0){return 0 ;}
        if (haystack.length()<bLenth){return -1;} //如果前面比后面短，直接失败

        for (int i = 0 ; i < haystack.length() ; i++){
            if (haystack.charAt(i) == needle.charAt(0)){//只有第一个字符串的字符等于第二个字符串的第一时候才开始比较

                if (haystack.length()-i < bLenth){
                    //如果前面剩余的比后面短，直接失败
                    return -1;
                }

                for (int j = 0 ; j < bLenth ; j++){

                   if (j == bLenth- 1 && haystack.charAt(i+j) == needle.charAt(j)){
                       //如果一直到needle的最后一个都是相匹配的
                       return i;
                   }
                   if (haystack.charAt(i+j) != needle.charAt(j)){
                       //如果有一个不相等直接终止
                       break;
                   }
               }
            }
        }
        return -1;
    }

    /**
     * 27. 移除元素（dzy完全自创）
     * 此题思路，关于数组删除的，就是巧妙利用其数组长度的思路，利用长度赋值，且交换等！
     */
    public int removeElement(int[] nums, int val) {
        //元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
        int newLenth = 0;
        for (int i = 0 ; i< nums.length ; i++){
            if (nums[i] == val ){
                if (i == nums.length-1){
                    break;
                }
                if (nums[i] == nums[i+1]){
                    //一直往下走
                }else {//走到第一个不是这个数的地方，赋值
                    nums[newLenth] = nums[i+1];
                    nums[i+1] = val;
                    newLenth++;
                }

            }else{
                newLenth++;
            }
        }
        return newLenth + 1;
    }


    /**
     * 26. 删除有序数组中的重复项（dzy完全自创）
     */
    public int removeDuplicates(int[] nums) {

        int newLenth = 0;
        for (int i = 1 ; i< nums.length ; i++){
            //如果此数和前一个数相等，则继续走,什么都不用做
            if (nums[i] == nums[i-1]){
               //
            }else{//如果不相等，则有一个不相等的,就代表数组长度+1，且直接当前数值赋值到长度位置即可
                newLenth++;
                nums[newLenth] = nums[i];
            }
        }
        //数组是从0开始的，所以长度要+1
        return newLenth + 1 ;
    }

    /**
     * 507. 完美数（南邮真题）（dzy完全自创）
     */
    public boolean checkPerfectNumber(int num) {

        //要先求其所有的正因子，除了他自己
        int sum = 0;
        for(int i = 1 ; i<num ; i++){
            if(num%i == 0){//如果余数等于0，则表明其是正因子
                sum = sum  + i;
            }
        }
        if (num == sum){
            return true;
        }else {
            return false;
        }
    }
    /**
     * 21. 合并两个有序链表(dzy半自创)
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //头结点 绝了！巧用
        ListNode head = new ListNode();
        ListNode list3 = head;//这个head赋给list3

        while(list1!= null && list2 != null){

        if (list1.val <list2.val){
            //注意一定要从next开始，下面都是
            list3.next= list1;
            list3 = list3.next;
            list1 =list1.next;
        }else{
            list3.next= list2;
            list3 = list3.next;
            list2 =list2.next;
        }
        }
        if(list1!= null ){
            list3.next = list1;
        }else{
            list3.next = list2;
        }
        //最后一定要从head节点的nex开始访问！
        return head.next;
    }


    /**
     * 20. 有效的括号（dzy完全自创）
     */
    public boolean isValid(String s) {
        //很明显是用栈的思想
        //创建一个栈
        int top = 0;
        char[] stack = new char[10000];

        for (int i =0; i<s.length() ;i++){
            if (s.charAt(i) == '('){
                //入栈
                stack[top] = '(';
                top++;
            }
            if (s.charAt(i) == '{'){
                //入栈
                stack[top] = '{';
                top++;
            }
            if (s.charAt(i) == '['){
                //入栈
                stack[top] = '[';
                top++;
            }
            if (s.charAt(i) == ')'){
                //top-1>= 0代表 栈不是上来就是）这个
                if ( top-1>= 0 && stack[top-1] == '('){
                    //出栈
                    top--;
                }else{
                    return false;
                }

            }
            if (s.charAt(i) == '}'){
                if ( top-1>= 0 && stack[top-1] == '{'){
                    //出栈
                    top--;
                }else{
                    return false;
                }
            }
            if (s.charAt(i) == ']'){
                if ( top-1>= 0 && stack[top-1] == '['){
                    //出栈
                    top--;
                }else{
                    return false;
                }
            }
        }
        if (top == 0){
            return true;
        }else return false;
    }

    /**
     * 14. 最长公共前缀（dzy完全自创）
     */
    public String longestCommonPrefix(String[] strs) {

        String result = "";
        //先是一个for循环找到一个字符串的长度最小值（找到最小长度的原因，是要跟着最小长度进行循环的）
        int minLength = 200;
        for(int i = 0 ;i <strs.length ; i++){
            if (strs[i].length() < minLength){
                minLength = strs[i].length();
            }
        }

        int key = 0;
        for (int i= 0 ; i<minLength ; i++){
            //每一个都等于第一个字符串的第i个字符
            char temp = strs[0].charAt(i);
            for (int j = 0 ;j<strs.length ;j++){
                //这里是如果每一个的这个位置的字符都等于第一个字符串的此位置的字符，则代表是公共前缀
               if (strs[j].charAt(i) != temp){
                   //定义了一个开关，当里面的循环中断的时候，开关打开，外部的循环也跟着中断
                   key = 1;
                   break;
               }
           }
            if (key != 1){
                //只有是公共前缀的时候才加在一起
                result = result + temp;
            }
            if (key == 1){//不是则终止所有循环
                break;
            }
        }

        return result;
    }

    /**
     *13. 罗马数字转整数
     */
    public int romanToInt(String s) {
        // Character：字符 Integer：整数数值 这个map函数一定要会
        int result = 0;
        Map<Character ,Integer> map = new HashMap<>();
        map.put('I' ,1);
        map.put('V' ,5);
        map.put('X' ,10);
        map.put('L' ,50);
        map.put('C' ,100);
        map.put('D' ,500);
        map.put('M' ,1000);

        //用这个for循环遍历出整个字符串的每一个字符
        for (int i = 0 ; i<s.length() ; i++){
            //6种特殊情况就用六种if来直接即可 字符串的s.charAt(i)函数就是得到字符串的第i个字符
            if ( i != s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
                result = result + 4;
                //i++的意思是它是一个两个组合，所以你要跳过两个
                i++;
            }else if ( i != s.length() - 1 && s.charAt(i) == 'I' && s.charAt(i+1) == 'X'){
                result = result + 9;
                i++;
            }else if ( i != s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i+1) == 'L'){
                result = result + 40;
                i++;
            }else if ( i != s.length() - 1 && s.charAt(i) == 'X' && s.charAt(i+1) == 'C'){
                result = result + 90;
                i++;
            }else if ( i != s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
                result = result + 400;
                i++;
            }else if ( i != s.length() - 1 && s.charAt(i) == 'C' && s.charAt(i+1) == 'M'){
                result = result + 900;
                i++;
            }else{
                //只有上面的是特殊情况，其他都是直接单个的字符相加即可
                //map.get(s.charAt(i));合理利用map函数从其中取值
                result = result + map.get(s.charAt(i));
            }
        }
        return result;

    }

    /**
     * 9.回文数
     */
    public boolean isPalindrome(int x) {
        int circle = 0;
        int key = x;
        if (x<0){
            return false;
        }
        //此循环可以把key整数变成翻过来的，例如123变成321
        while(key!=0){
            circle = circle * 10 + key % 10;
            key = key / 10;
            //circle = circle * 10 + key % 10 ;key = key/10
            //key一直除以10往下走，而对于circle要一直*10再加上key%10的余数
        }
        return x == circle;
    }

    /**
     * 1.两数之和 √
     */
    public int[] twoSum(int[] nums,int target){
        int[] result = new int[2];
        for ( int i = 0 ; i<nums.length ;i++){
            //j=i+1从每个地方往后算，且避免了重复和相同的下标出现的情况
            for (int j = i +1 ; j<nums.length ;j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

}
