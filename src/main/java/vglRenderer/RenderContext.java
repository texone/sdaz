/* Generated by Together */

package vglRenderer;

class RenderContext {
    /**
     * Initialise renderer. The renderer has a default viewport of (0,0,1,1) and a window of (0,0,1,1). Until a VGLDocument
     * and a VGLRenderingStrategy has been supplied, render() will do nothing.
     */
    public RenderContext() {
        window = new VGLWindow();
        viewport = new VGLViewport();
        this.computeViewportToWindowMap();
    }

    /** Get viewport */
    public VGLViewport getViewport() {
        return viewport;
    }

    /** Specify viewport. The renderer will then render only the elements which intersect the viewport. */
    public void setViewport(VGLViewport viewport) {
        this.viewport = viewport;
        this.computeViewportToWindowMap();
    }

    public VGLWindow getWindow() {
        return window;
    }

    /** Specify window on physical device in which to render document elements that intersect the viewport. */
    public void setWindow(VGLWindow window) {
        this.window = window;
        this.computeViewportToWindowMap();
    }

    private void computeViewportToWindowMap() {
        double x = ((double)window.xmax - (double)window.xmin) / (viewport.xmax - viewport.xmin);
        double y = ((double)window.ymax - (double)window.ymin) / (viewport.ymax - viewport.ymin);
        xMap = (long)(x * Constants.SHIFT);
        yMap = (long)(y * Constants.SHIFT);
    }

    public int mapXCoordVToW(long x) {
        return window.xmin + (int)(((x - viewport.xmin) * xMap) / Constants.SHIFT);
    }

    public int mapYCoordVToW(long y) {
        return window.ymin + (int)(((y - viewport.ymin) * yMap) / Constants.SHIFT);
    }

   	public int mapXScalarVToW(long x) {
        return (int)((x * xMap) / Constants.SHIFT);
    }

    public long getXMap() {
        return xMap;
    }

    public long getYMap() {
        return yMap;
    }

    /**
     * @clientCardinality 1
     * @supplierCardinality 1 
     */
    private VGLViewport viewport;

    /**
     * @clientCardinality 1
     * @supplierCardinality 1 
     */
    private VGLWindow window;
    private long xMap;
    private long yMap;
}