package ar.edu.unlp.info.oo1.jobScheduler;

public class LastInFirstOut extends JobScheduler {
    @Override
    public JobDescription next() {
        JobDescription nextJob = jobs.get(jobs.size()-1);
        this.unschedule(nextJob);
        return nextJob;
    }
}
