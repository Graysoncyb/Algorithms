package disjointsets;

/**
 * @author Yuanbin Cai
 * @date 2022/7/29
 **/
public interface DisjointSets {
    boolean isConnected(int p, int q);

    void union(int p, int q);
}
