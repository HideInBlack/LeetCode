import java.util.Scanner;

class Test {

    public static void main(String[] args) {


//        /**
//         * 进制转换         （直接所有的正序余数再加最后一个余数，然后倒数即可？）
//         * 十进制转任意进制：这个数对基数依次取余，将余数倒序输出，在倒序输出余数之前正序输出最后一次的商。
//         * 任意进制转十进制：直接逐级相加例如3进制1121 = 1*3的3次方 + 1*3的2次方 + 2*3 + 1*3的零次方
//         * 我的巧妙之处：1.我直接用字符串反向相加，形成的就是最终的倒叙！2.对于负数先当做正数来做，最后加个负号即可
//         */
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        List<String> listResult = new ArrayList<>();
//        Map<Integer,String> map = new HashMap<>();
//        map.put(10,"A");
//        map.put(11,"B");
//        map.put(12,"C");
//        map.put(13,"D");
//        map.put(14,"E");
//        map.put(15,"F");
//        //把所有的数据存储到list里面
//        while (scanner.hasNext()){
//            list.add(scanner.nextInt());
//        }
//
//        for (int i = 1; i < list.size() ; i=i+2){
//            int key= 0;
//            if (list.get(i)<0){//如果小于0，先取正数，最后再加负号
//                list.set(i,-list.get(i));
//                key = 1;
//            }
//            int some = list.get(i+1);//进制数
//            int res = list.get(i)/some;//第一个除数结果
//            int crs = list.get(i)%some;//第一个余数
//            String result;
//            if (crs>9){
//                result = map.get(crs);
//            } else{
//                result = ""+ crs ;
//            }
//            while (res>=some){//最后的一个除数必然是大于进制的
//                crs = res%some ;
//                if (crs > 9){
//                    result = map.get(crs) + result;
//                }else {
//                    result = crs + result ;//在这里就是直接倒序了
//                }
//                res = res/some ;
//            }
//            if (res != 0){
//                result = res + result;
//            }
//            //由于是负数，则需要加一个负号！
//            if (key == 1){result = "-" + result ;}
//
//            listResult.add(result);
//        }
//        for (int i = 0 ; i<listResult.size() ; i++){
//            System.out.println(listResult.get(i));
//        }


//        /**
//         * 新对称素数问题（已修复）17:05-15:30
//         * 素数就是质数！ 质数就是除了1和本身，没有其他因数得数！正好与合数相反！
//         * 关键：对于key的妙用来节省运行时间！
//         * 还有就是：1不是素数也不是合数！ 注意这些特殊情况
//         */
//
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] array = new int[n];
//        for (int i = 0 ; i < n ;i++){
//            array[i] = scanner.nextInt();
//        }
//        //思路：先看其是不是素数，再看是不是对称的！
//        for (int i = 0 ; i < n ;i++){
//            if (array[i]>9999 || array[i] == 1){//先判断是都不大于五位
//                System.out.println("No");
//            }else{
//                //再看是不是素数
//                int keySu = 0 ;
//                for (int j = 2 ; j < array[i] ; j++){
//                    if (array[i]%j == 0){//说明不是素数
//                        System.out.println("No");
//                        keySu = 1;
//                        break;
//                    }
//                }
//                //此时是素数
//                if (keySu == 0){//如果走了一圈还是0则表明是素数
//                    //在进行判断是不是对称
//                    String str = "" + array[i];
//                    //对于整数可以用字符处理
//                    int key = 0 ;
//                    for (int k = 0 ; k < str.length()/2 ; k++ ){
//                        if (str.charAt(k) != str.charAt(str.length()-1-k)){
//                            key = 1;//如果有一个不等的就是把钥匙置位1
//                            break;
//                        }
//                    }
//                    if (key == 1){
//                        System.out.println("No");
//                    }else{
//                        System.out.println("Yes");
//                    }
//                }
//            }
//
//        }



//        /**
//         * 求最值问题
//         * 关键：是对于多组数据的输入，并且巧妙运用了list！
//         */
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//
//        //while+scanner.hasNext()代表着是否下一个还有！
//        while (scanner.hasNext()){
//            //16:05-
//            int n = scanner.nextInt();
//            int[] array = new int[n];
//            for (int i = 0; i < n ; i++){
//                array[i] = scanner.nextInt();
//            }
//            int max = array[0]; int min = array[0] ;
//            for (int i = 0 ; i < n; i++){
//                if (array[i]<min){min = array[i] ; }
//                if (array[i]>max){max = array[i] ; }
//            }
//            list.add(max);
//            list.add(min);
//        }
//        //最后两个两个的输入！
//        for (int i = 0 ; i<list.size() ; i=i+2) {
//            System.out.print(list.get(i));
//            System.out.print(" " + list.get(i+1));
//            System.out.println();//换行
//        }




//        /**
//         * 最小质数合数之和问题
//         */
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int minZ = 0;
//        int minH = 0;
//        for (int i = n+1; ; i++){
//            int count = 0;
//            for (int j = 1; j < i ; j++){
//                if ( i%j == 0 && j!= 1){//被整除了，说明是合数
//                    if (minH == 0){
//                        minH = i;
//                    }
//                    break;
//                }else {//没有被整除就+1
//                        count++;
//                }
//            }
//            if (count == i-1){
//                if (minZ == 0){
//                    minZ = i;
//                }
//            }
//            if (minH != 0 && minZ != 0){
//
//                break;
//            }
//
//        }
//        //System.out.println("最小合数:" + minH + "  最小质数：" + minZ);
//        System.out.println(minH + minZ);


//        /**
//         *回文回文(正确！）
//         * ！！！字符串方法巧妙解决大小写相等的问题！！！
//         * 换个思路解决大小写问题：用字符串的一个方法：a.equalsIgnoreCase(b)
//         * 注意：字符串是直接可以和字符相加的
//         * 30-58
//         */
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        //强行map解决哈希的问题！
//
//        //要不要写空字符串？
//        int key = 0;
//        for (int i = 0 ; i < str.length()/2 ; i++){
//            String str1 = "" + str.charAt(i);
//            String str2 = "" + str.charAt(str.length()-1-i);
//            if (!str1.equalsIgnoreCase(str2)){
//                System.out.println("No");
//                key = 1;
//                break;
//            }
//        }
//        if (key == 0){
//            System.out.println("Yes");
//        }


//        /** 用map hash：Map<Character,Character> map = new HashMap<>();
//         *回文回文(暴力解决大小写问题！)（正确）
//         * 30-58
//         */
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        //强行map解决哈希的问题！
//        Map<Character,Character> map = new HashMap<>();
//        map.put('a','A');
//        map.put('b','B');
//        map.put('c','C');
//        map.put('d','D');
//        map.put('e','E');
//        map.put('f','F');
//        map.put('g','G');
//        map.put('h','H');
//        map.put('i','I');
//        map.put('j','J');
//        map.put('k','K');
//        map.put('l','L');
//        map.put('m','M');
//        map.put('n','N');
//        map.put('o','O');
//        map.put('p','P');
//        map.put('q','Q');
//        map.put('r','R');
//        map.put('s','S');
//        map.put('t','T');
//        map.put('u','U');
//        map.put('v','V');
//        map.put('w','W');
//        map.put('x','X');
//        map.put('y','Y');
//        map.put('z','Z');
//
//        map.put('A','a');
//        map.put('B','b');
//        map.put('C','c');
//        map.put('D','d');
//        map.put('E','e');
//        map.put('F','f');
//        map.put('G','g');
//        map.put('H','h');
//        map.put('I','i');
//        map.put('J','j');
//        map.put('K','k');
//        map.put('L','l');
//        map.put('M','m');
//        map.put('N','n');
//        map.put('O','o');
//        map.put('P','p');
//        map.put('Q','q');
//        map.put('R','r');
//        map.put('S','s');
//        map.put('T','t');
//        map.put('U','u');
//        map.put('V','v');
//        map.put('W','w');
//        map.put('X','x');
//        map.put('Y','y');
//        map.put('Z','z');
//
//        //要不要写空字符串？
//        int key = 0;
//        for (int i = 0 ; i < str.length()/2 ; i++){
//            if (str.charAt(i) != str.charAt(str.length()-1-i) &&  str.charAt(i) != map.get(str.charAt(str.length()-1-i))){
//                System.out.println("No");
//                key = 1;
//                break;
//            }
//        }
//        if (key == 0){
//            System.out.println("Yes");
//        }


//        /**
//         * 斐波那契数列(dzy正确)
//         * 35- 10 分做了两题！
//         */
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//       // int a = 0; int b = 1;
//
//        int result = 0;
//        if (n == 0){
//            System.out.println(0);
//        }else if ( n == 1){
//            System.out.println(1);
//        }else {
//            int[] array = new int[n+1];
//            array[0] = 0;array[1] = 1;
//            for (int i = 2;i<n+1 ;i++){
//                array[i] = array[i-1] + array[i-2];
//            }
//            System.out.println(array[n]);
//        }



//        /**(正确)
//         * 求两个正整数的最大公约数和最小公倍数
//         * 最大公约数：两个数的最大公共因数
//         * 最小公倍数：两个的最小公共倍数
//         */
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int numy = 1; int numb = 0; int min ; int max;
//        //先找ab的最小值；
//        if ( b < a){
//            min = b;
//            max = a;
//        }else {
//            min = a;
//            max = b;
//        }
//        for (int i = min ; i>0 ; i--){
//            if (a%i == 0 && b%i == 0){
//                //找到最大公因数
//                numy = i;
//                break;
//            }
//        }
//        for (int i = max ;i<=a * b ;i++){
//            if (i%a == 0 && i%b == 0){
//                numb = i;
//                break;
//            }
//        }
//        System.out.println(numy + " " + numb);





    }

//    /**
//     *  级数求和
//     */
//    public void getMin(int k){
//        double result = 0.00;
//        double temp ;
//        for (int i = 1 ; ; i++){
//            temp = (double)1/(double)i;
//            result = result + temp ;
//            if (result > k){
//                System.out.println(i);
//                break;
//            }
//        }
//    }
//
//    /**
//     *最小质数合数之和问题
//     */
//    public void getSum(int n){
//        int minZ = 0;
//        int minH = 0;
//        for (int i = n+1; ; i++){
//            int count = 0;
//            for (int j = 1; j < i ; j++){
//                if ( i%j == 0 && j!= 1){//被整除了，说明是合数
//                    if (minH == 0){
//                        minH = i;
//                    }
//                }else {//没有被整除就+1
//                    count++;
//                }
//            }
//            if (count == i-1){
//                if (minZ == 0){
//                    minZ = i;
//                }
//            }
//            if (minH != 0 && minZ != 0){
//
//                break;
//            }
//
//        }
//        System.out.println(minH + minZ);
//    }

//        /**
//         * 华强种瓜(dzy正确) 一定要仔细！！
//         */
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int r = scanner.nextInt();
//        int[][] location = new int[k][2];
//        for (int i = 0; i < k; i++) {
//            location[i][0] = scanner.nextInt();
//            location[i][1] = scanner.nextInt();
//        }
//
//        int[][] tian = new int[n][n];
//        //把所有的瓜置为0
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                tian[i][j] = 0;
//            }
//        }
//        //浇水
//        for (int h = 0; h < k; h++) {//h是洒水器数量
//            //这个地方一定要-0.5！因为他们给的是比坐标大1的！！！
//            double sx = location[h][0] -0.5;
//            double sy = location[h][1] -0.5;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    //这个地方一定要+0.5！因为他们就是坐标！！！
//                    double x = i + 0.5;
//                    double y = j + 0.5;
//                    if ((x-sx)*(x-sx) + (y-sy)*(y-sy) <= r*r){
//                        //置为1 代表已被浇水了
//                        tian[i][j] = 1;
//                    }
//                }
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (tian[i][j] == 1){
//                    int x = i+1 ;
//                    int y = j+1 ;
////                    System.out.println("(" + x + "," + y+")");
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);


//        //30-20结束
//        /**
//         *小明喝可乐（dzy正确）
//         * 在纸上写一写！ 一定要根据初始条件推算出来！
//         */
//        Scanner scanner = new Scanner(System.in);
//        int hand = scanner.nextInt();
//        int discount = scanner.nextInt();
//        int result = hand ;
//        while (hand/discount  >0){
//            //一开始的10 然后一直加可以换的
//            result = result + hand/discount ;
//            //下一次可以赠送的是 手上的/3 + 手上剩余的
//            hand = hand/discount + hand%discount;
//        }
//        System.out.println(result);


    //        /**
//         * 小明与选择题00-25（经过纠错，成功完成！）
//         * double mid = (double)(a+b+c+d)/(double)4;//mid平均长度
//         * 这里的mid一定要用double强制转换才谨慎！严谨！！！
//         */
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        int d = scanner.nextInt();
//
//        Map<Integer,String> map = new HashMap<>();
//        map.put(0,"A");
//        map.put(1,"B");
//        map.put(2,"C");
//        map.put(3,"D");
//
//        //0是默认，1代表长 ，-1代表短
//        int[] array = {0,0,0,0};//用一个数组定义长短的问题
//        double mid = (double)(a+b+c+d)/(double)4;//mid平均长度
//
//        if (a>mid){
//            array[0] = 1;
//        }else if (a<mid){
//            array[0] = -1;
//        }
//        if (b>mid){
//            array[1] = 1;
//        }else if (b<mid){
//            array[1] = -1;
//        }
//        if (c>mid){
//            array[2] = 1;
//        }else if (c<mid){
//            array[2] = -1;
//        }
//        if (d>mid){
//            array[3] = 1;
//        }else if (d<mid){
//            array[3] = -1;
//        }
//        //遍历数组技术，长的有几个，短的有几个
//        int count1 = 0;
//        int count2 = 0;
//        for (int i= 0 ; i<4 ;i++){
//            if (array[i] == 1){
//                count1++;
//            }else if (array[i] == -1){
//                count2++;
//            }
//        }
//        if (count1==3){//如果有三个长的
//            for (int i= 0 ; i<4 ;i++){
//                if (array[i] != 1){//那就找到这个短的
//                    System.out.println(map.get(i));
//                }
//            }
//        }else if (count2 == 3){//如果有三个短的
//            for (int i= 0 ; i<4 ;i++){
//                if (array[i] != -1){//那就找到这个长的
//                    System.out.println(map.get(i));
//                }
//            }
//        }else if (count1 == count2 && count2 == 0){
//            System.out.println("B");
//        }else {
//            System.out.println("C");
//        }



//        /**
//         *忠诚的骑士（正确，只用了十分钟！）
//         * 此方法更巧妙！
//         * 试一下换个方法暴力相加50-60
//         */
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        int result = 0 ;
//        int count = 1;
//        int temp = count;
//        for (int i = 1 ; i <= k ;i++){
//            result = result  +  count;
//            temp--;
//            //巧妙的利用count作为常量关系，temp作为每次递减的对象
//            //利用它们两个的关系巧妙实现在for循环递增的时候实现 1+2+2+3+3+3=14
//            if (temp == 0){
//                count++;
//                temp = count;
//            }
//
//        }
//        System.out.println(result);

//        /**
//         * 忠诚的骑士25-48(正确 23分钟)
//         */
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//
//        int result = 0 ;
//        for (int i = 1 ; i <= k;i++){
//            if (k == i*(i+1) / 2){
//
//                for (int j = 1 ; j<=i ; j++){
//                    //细心！被写错i  j
//                    result = result + j*j;
//                }
//                System.out.println(result);
//                break;
//            }else if(k < i*(i+1) / 2){
//                //找第一个大于它的
//                for (int j = 1 ; j<=i-1 ; j++){
//                    result = result + j*j;
//                }
//                result = result + (k - (i-1)*(i) / 2) * i;
//                System.out.println(result);
//                break;
//            }
//
//        }


//        /**
//         *萌萌摘苹果 15-25(正确)
//         */
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();//n书上的苹果总数
//        int[] array = new int[n];
//        for (int i = 0 ; i < n ; i++){
//            array[i] = scanner.nextInt();
//        }
//        int h = scanner.nextInt();//h达到的最高高度 还没加30
//
//        int count = 0;
//        for (int i = 0 ; i < n ; i++){
//            if (h + 30 >= array[i]){
//                count++;
//            }
//        }
//        System.out.println(count);
//        if (count == n){
//            System.out.println("Yes");
//        }else {
//            System.out.println("No");
//        }









    public void test(){
        System.out.println("仅仅只是测试的一个方法");
    }








}
