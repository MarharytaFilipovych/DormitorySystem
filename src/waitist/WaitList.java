package waitist;

import application.Application;
import enums.Status;

import java.util.Iterator;
import java.util.List;

public class WaitList {
    private List<Application> waitlistedApplications;
    private int limit;

    public WaitList(List<Application> waitlistedApplications, int limit) {
        this.waitlistedApplications = waitlistedApplications;
        this.limit = limit;
    }

    public boolean addApplication(Application application) {
        if (waitlistedApplications.size() < limit) {
            application.addToWaitlist();
            waitlistedApplications.add(application);
            return true;
        }
        return false;
    }

    public boolean removeApplication(long applicationId) {
        Iterator<Application> iterator = waitlistedApplications.iterator();
        while (iterator.hasNext()) {
            Application app = iterator.next();
            if (app.getId() == applicationId) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Application getNextApplication() {
        if (!waitlistedApplications.isEmpty()) return waitlistedApplications.getFirst();
        return null;
    }

    public int getPosition(long applicationId) {
        for (int i = 0; i < waitlistedApplications.size(); i++) {
            if (waitlistedApplications.get(i).getId() == applicationId) return i + 1;
        }
        return -1;
    }

    public boolean processWaitlist() {
        if (waitlistedApplications.isEmpty())  return false;
        Application nextApplication = getNextApplication();
        nextApplication.setStatus(Status.WAITLISTED);
        waitlistedApplications.removeFirst();
        System.out.println("Processing application " + nextApplication.getId() + " from waitlist");
        return true;
    }


    public List<Application> getWaitlistedApplications() {
        return waitlistedApplications;
    }

    public void setWaitlistedApplications(List<Application> waitlistedApplications) {
        this.waitlistedApplications = waitlistedApplications;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
