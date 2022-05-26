class Main {

  public static void main(String args[]) {
    for (int i = 1; i <= 100; i++) {
      String str = "";

      // ここから記述
      if(i%15==0){       // iが15の倍数の時
        str = "FizzBuzz";
      }else if(i%3==0){  // iが3の倍数の時
        str = "Fizz";
      }else if(i%5==0){  // iが5の倍数の時
        str = "Buzz";
      }else{             // その他
        str = Integer.valueOf(i).toString();  // intをstringに変更
      }
      // ここまで記述

      System.out.println(str);
    }
  }
}
