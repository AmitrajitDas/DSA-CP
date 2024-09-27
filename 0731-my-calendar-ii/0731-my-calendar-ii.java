class Event {
    int start, end;
    // Constructor to initialize an Event with start and end times
    Event(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCalendarTwo {
    // List to store all booked events
    List<Event> events;
    // List to store all overlapping events (i.e., double bookings)
    List<Event> overlappingEvents;

    // Constructor to initialize the lists
    public MyCalendarTwo() {
        events = new ArrayList<>();           // Holds all events that are booked
        overlappingEvents = new ArrayList<>(); // Holds events that are double-booked (overlapping)
    }

    // Helper method to check if two events overlap
    private boolean isOverlap(Event e, int start, int end) {
        // An event overlaps if the max start time is less than the min end time
        // This ensures that the intervals intersect
        return Math.max(e.start, start) < Math.min(e.end, end);
    }
    
    // Main method to book an event
    public boolean book(int start, int end) {
        // Step 1: Check if the new event would cause a triple booking (overlap with an already double-booked event)
        for (Event e : overlappingEvents) {
            if (isOverlap(e, start, end)) {
                return false;  // If there is an overlap with an event in the overlappingEvents list, return false
            }
        }

        // Step 2: Check for overlaps with already booked events
        // If there's an overlap, we create a new overlapping event (double booking)
        for (Event e : events) {
            if (isOverlap(e, start, end)) {
                // Record the overlapping interval
                overlappingEvents.add(new Event(Math.max(e.start, start), Math.min(e.end, end)));
            }
        }

        // Step 3: Add the new event to the list of booked events
        events.add(new Event(start, end));
        
        // Booking is successful, return true
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start, end);
 */
