

class Main {

  public static void main(String args[]) {
    // 昇順にソートされた配列
    int[] sortedArray = { 1, 2, 3, 5, 12, 7890, 12345 };
    // 探索対象の番号
    int targetNumber = 7890;
    // 探索実行
    int targetIndex = new Main().serchIndex(sortedArray, targetNumber);
    // 結果出力
    System.out.println(targetIndex);
  }

  private int serchIndex(int[] sortedArray, int targetNumber) {

    // ここから記述
    int searchIndex_low = 0;                        // 捜索範囲の最初
    int searchIndex_high = sortedArray.length - 1;  // 捜索範囲の最後

    while(searchIndex_low <= searchIndex_high){
      // 「探索対象の数値」 >「配列の中間の値」 更新・継続
      if(targetNumber > sortedArray[(searchIndex_low + searchIndex_high)/2]){
        searchIndex_low = (searchIndex_low + searchIndex_high)/2 + 1;

      // 「探索対象の数値」 =「配列の中間の値」 更新・継続
      }else if(targetNumber < sortedArray[(searchIndex_low + searchIndex_high)/2]){
        searchIndex_high = (searchIndex_low + searchIndex_high)/2 - 1;

      // 「探索対象の数値」 =「配列の中間の値」 終了
      }else{
        return (searchIndex_low + searchIndex_high)/2;
      }
    }
    // ここまで記述

    // 探索対象が存在しない場合、-1を返却
    return -1;
  }
}
