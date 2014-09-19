package com.bei.fir.fir;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Created by benny on 14-9-19.
 */
public class FirUploadRecorder extends Recorder
{

    private String apiToken;
    @DataBoundConstructor
    public FirUploadRecorder(String apiToken)
    {
        this.apiToken = apiToken;
    }

    public BuildStepMonitor getRequiredMonitorService()
    {
        return BuildStepMonitor.NONE;
    }

    @Override public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener)
    {
        if (build.getResult().isWorseOrEqualTo(Result.FAILURE)){
            return false;
        }
        listener.getLogger().println("uploading to fir");


        return true;
    }
}
