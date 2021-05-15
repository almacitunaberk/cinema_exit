class QueueNode
{
    Point pt; // The cordinates of a cell
    int dist; // cell's distance of from the source

    public QueueNode(Point pt, int dist)
    {
        this.pt = pt;
        this.dist = dist;
    }
}