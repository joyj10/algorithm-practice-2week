package assignment;

class ViewLog {
    int postId;
    String userId;
    String timestamp; // "2025-07-24 09:30:00"

    public ViewLog(int postId, String userId, String timestamp) {
        this.postId = postId;
        this.userId = userId;
        this.timestamp = timestamp;
    }
}