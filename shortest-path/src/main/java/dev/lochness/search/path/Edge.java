package dev.lochness.search.path;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Edge implements Comparable<Edge> {

    private Integer v1;
    private Integer v2;
    private Integer cost;

    public Edge(Integer v1, Integer v2, Integer cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getV1() {
        return v1;
    }

    public void setV1(Integer v1) {
        this.v1 = v1;
    }

    public Integer getV2() {
        return v2;
    }

    public void setV2(Integer v2) {
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "(" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", cost=" + cost +
                ')';
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.getCost(), other.getCost());
    }

}
