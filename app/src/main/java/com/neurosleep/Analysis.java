package com.neurosleep;

public class Analysis {
    private String Alpha;
    private String Beta;
    private String Delta;
    private String Gamma;
    private String Theta;
    private String Seconds;

    public Analysis() {
    }

    public Analysis(String Alpha, String Beta, String Delta, String Gamma, String Theta, String Seconds) {
        this.Alpha = Alpha;
        this.Beta = Beta;
        this.Delta = Delta;
        this.Gamma = Gamma;
        this.Theta = Theta;
        this.Seconds = Seconds;
    }

    public String getAlpha() {
        return Alpha;
    }

    public void setAlpha(String alpha) {
        this.Alpha = alpha;
    }

    public String getBeta() {
        return Beta;
    }

    public void setBeta(String beta) {
        this.Beta = beta;
    }

    public String getDelta() {
        return Delta;
    }

    public void setDelta(String delta) {
        this.Delta = delta;
    }

    public String getGamma() {
        return Gamma;
    }

    public void setGamma(String gamma) {
        this.Gamma = gamma;
    }

    public String getTheta() {
        return Theta;
    }

    public void setTheta(String theta) {
        this.Theta = theta;
    }

    public String getSeconds() {
        return Seconds;
    }

    public void setSeconds(String seconds) {
        this.Seconds = seconds;
    }



}
