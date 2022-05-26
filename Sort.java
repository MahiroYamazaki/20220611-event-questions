import java.util.Arrays;
import java.util.stream.IntStream;

class Main {

  public static void main(String[] args) {
    // ランダムに並べられた重複のない整数の配列
    var array = new int[] { 5, 4, 6, 2, 1, 9, 8, 3, 7, 10 };
    // ソート実行
    var sortedArray = new Main().sort(array);
    // 結果出力
    Arrays.stream(sortedArray).forEach(System.out::println);
  }

  private int[] sort(int[] array) {
    // 要素が一つの場合はソートの必要がないので、そのまま返却
    if (array.length == 1) {
      return array;
    }

    // 配列の先頭を基準値とする
    var pivot = array[0];

    // ここから記述
    int start = 0;
    int end = array.length - 1;

    while(start<end){
      // 交換条件を満たした時
      if(array[start] >= pivot && array[end] < pivot){
        var tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
      // 先頭側の注目している数が条件を満たさない時
      }else if(array[start] < pivot && array[end] < pivot){
        start++;
      // 後方側の注目している数が条件を満たさない時 & その他
      }else{
        end--;
      }
    }

    // ピボットより小さいグループの配列を作成
    int[] front = new int[start + 1];
    System.arraycopy(array, 0, front, 0, start + 1);

    //ピボット以上のグループの配列を作成
    int[] back = new int[array.length - start - 1];
    System.arraycopy(array, start + 1, back, 0, array.length - start - 1);

    // 両方の配列を再起によりソート
    front = sort(front);
    back = sort(back);

    // ソート完了した配列を上書きする
    System.arraycopy(front, 0, array, 0, start + 1);
    System.arraycopy(back, 0, array, start + 1, array.length - start - 1);

    return array;
    // ここまで記述

  }
}
