package com.example.demo.quickstart;

public class OutputHelper {
    IOutputGenerator outputGenerator;

    public void generatorOutput(){
        outputGenerator.generatorOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator){
        this.outputGenerator = outputGenerator;
    }
}
