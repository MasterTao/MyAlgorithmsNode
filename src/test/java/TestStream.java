import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tao
 * @date 2021/7/8 4:58 下午
 */
public class TestStream {


    public static void main(String[] args) {
        List<GoodsDao> list = new ArrayList<>();
        list.add(new GoodsDao(1, 1));
        list.add(new GoodsDao(2, 2));
        list.add(new GoodsDao(3, 3));
        list.add(new GoodsDao(4, 4));
        list.add(new GoodsDao(5, 5));
        list.add(new GoodsDao(6, 6));

        List<String> collect = list.stream().map(goodsDao -> String.valueOf(goodsDao.getVirtualGoodsId())).collect(Collectors.toList());

        List<String> list1 =  new ArrayList<>();
        list1.add("1");
        list1.add("1");
        list1.add("1");
        list1.add("1");
        list1.add("2");

        List<String> removeList = new ArrayList<>();
        removeList.add("1");
        removeList.add("2");

        list1.removeIf(removeList::contains);

        System.out.println(list1.size());
    }
}


class GoodsDao {
    private Integer goodsId;
    private Integer virtualGoodsId;

    public GoodsDao(Integer goodsId, Integer virtualGoodsId) {
        this.goodsId = goodsId;
        this.virtualGoodsId = virtualGoodsId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getVirtualGoodsId() {
        return virtualGoodsId;
    }

    public void setVirtualGoodsId(Integer virtualGoodsId) {
        this.virtualGoodsId = virtualGoodsId;
    }
}