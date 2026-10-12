package ar.edu.unlp.info.oo1.jobScheduler;

public class FirstInFirstOut extends JobScheduler {
    @Override
    public JobDescription next() {
        JobDescription nextJob = jobs.get(0);
        this.unschedule(nextJob);
        return nextJob;
    }
}
