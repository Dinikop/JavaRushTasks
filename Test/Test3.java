class Plane {
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Plane(Dispatcher dispatcher) { this.dispatcher = dispatcher; }
    public synchronized Point getLocation() { return location; }
    public synchronized void setLocation(Point location) {
        this.location = location;
        if (location.equals(destination)) dispatcher.requestLanding(this);
    }

    public void setLocation(Point location) {
        boolean reachedDestination;
        synchronized(this){
            this.location = location;
            reachedDestination = location.equals(destination);
        }
        if (reachedDestination) dispatcher.requestLanding(this);
    }
}

class Dispatcher {
    private final Set planes;
    private final Set< Plane > planesPendingLanding;

    public Dispatcher() {
        planes = new HashSet();
        planesPendingLanding = new HashSet();
    }
    public synchronized void requestLanding(Plane plane) {
        planesPendingLanding.add(plane);
    }

    public synchronized Image getMap() {
        Image image = new Image();
        for (Plane plane : planes) image.drawMarker(plane.getLocation());
        return image;
    }

    public Image getMap() {
        Set copy;
        synchronized(this){
            copy = new HashSet( planes);
        }
        Image image = new Image();

        for (Plane plane : copy) image.drawMarker(plane.getLocation());
        return image;
    }
}