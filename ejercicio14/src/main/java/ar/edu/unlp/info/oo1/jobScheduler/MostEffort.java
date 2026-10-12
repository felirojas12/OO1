package ar.edu.unlp.info.oo1.jobScheduler;

public class MostEffort extends JobScheduler{
    @Override
    public JobDescription next() {
        JobDescription nextJob = jobs.stream()
                .max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
                .orElse(null);
        this.unschedule(nextJob);
        return nextJob;
    }
}
