package com.soecode.lyf.entity;

public class Wages {
    private int id;             //id
    private String name;        //名字
    private long cardNo;        //银行卡号
    private String job;         //职务
    private double basicWages;  //基本工资
    private double coefficient; //系数
    private double restWages;   //月日工资
    private int trunDay;        //出勤天数
    private double TRUEWages;   //出勤工资
    private int seniority;      //工龄
    private double other;       //顶班
    private double otherWages;  //顶班工资
    private double allowance;   //津贴
    private double deduction;   //罚款
    private double actualWages; //实发工资
    private String writeName;   //签名
    private String DATENo;      //时间
    private String business;    //单位

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCardNo() {
        return cardNo;
    }

    public void setCardNo(long cardNo) {
        this.cardNo = cardNo;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getBasicWages() {
        return basicWages;
    }

    public void setBasicWages(double basicWages) {
        this.basicWages = basicWages;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getRestWages() {
        return restWages;
    }

    public void setRestWages(double restWages) {
        this.restWages = restWages;
    }

    public int getTrunDay() {
        return trunDay;
    }

    public void setTrunDay(int trunDay) {
        this.trunDay = trunDay;
    }

    public double getTRUEWages() {
        return TRUEWages;
    }

    public void setTRUEWages(double TRUEWages) {
        this.TRUEWages = TRUEWages;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public double getOther() {
        return other;
    }

    public void setOther(double other) {
        this.other = other;
    }

    public double getOtherWages() {
        return otherWages;
    }

    public void setOtherWages(double otherWages) {
        this.otherWages = otherWages;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getActualWages() {
        return actualWages;
    }

    public void setActualWages(double actualWages) {
        this.actualWages = actualWages;
    }

    public String getWriteName() {
        return writeName;
    }

    public void setWriteName(String writeName) {
        this.writeName = writeName;
    }

    public String getDATENo() {
        return DATENo;
    }

    public void setDATENo(String DATENo) {
        this.DATENo = DATENo;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}
