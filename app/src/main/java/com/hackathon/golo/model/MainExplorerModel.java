package com.hackathon.golo.model;

import java.util.ArrayList;

public class MainExplorerModel {

    private String title;
    private boolean seeMore;
    private int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    private ArrayList<Explorer> explorerArrayList;

    public ArrayList<SearchResult> getSearchResultArrayList() {
        return searchResultArrayList;
    }

    public void setSearchResultArrayList(ArrayList<SearchResult> searchResultArrayList) {
        this.searchResultArrayList = searchResultArrayList;
    }

    private ArrayList<SearchResult> searchResultArrayList;
    private ArrayList<TravelMate> travelMateArrayList;
    private ArrayList<Offers> offersArrayList;

    public ArrayList<Offers> getOffersArrayList() {
        return offersArrayList;
    }

    public void setOffersArrayList(ArrayList<Offers> offersArrayList) {
        this.offersArrayList = offersArrayList;
    }

    public ArrayList<TravelMate> getTravelMateArrayList() {
        return travelMateArrayList;
    }

    public void setTravelMateArrayList(ArrayList<TravelMate> travelMateArrayList) {
        this.travelMateArrayList = travelMateArrayList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSeeMore() {
        return seeMore;
    }

    public void setSeeMore(boolean seeMore) {
        this.seeMore = seeMore;
    }

    public ArrayList<Explorer> getExplorerArrayList() {
        return explorerArrayList;
    }

    public void setExplorerArrayList(ArrayList<Explorer> explorerArrayList) {
        this.explorerArrayList = explorerArrayList;
    }


}
