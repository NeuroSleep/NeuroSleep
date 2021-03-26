package com.neurosleep;

public class Analysis {
    private Long Alpha;
    private Long Beta;
    private Long Delta;
    private Long Gamma;
    private Long Theta;

    public Analysis() {
    }

    public Analysis(Long Alpha, Long Beta, Long Delta, Long Gamma, Long Theta) {
        this.Alpha = Alpha;
        this.Beta = Beta;
        this.Delta = Delta;
        this.Gamma = Gamma;
        this.Theta = Theta;
    }

    public Long getAlpha() {
        return Alpha;
    }

    public void setAlpha(Long alpha) {
        this.Alpha = alpha;
    }

    public Long getBeta() {
        return Beta;
    }

    public void setBeta(Long beta) {
        this.Beta = beta;
    }

    public Long getDelta() {
        return Delta;
    }

    public void setDelta(Long delta) {
        this.Delta = delta;
    }

    public Long getGamma() {
        return Gamma;
    }

    public void setGamma(Long gamma) {
        this.Gamma = gamma;
    }

    public Long getTheta() {
        return Theta;
    }

    public void setTheta(Long theta) {
        this.Theta = theta;
    }




}
