/* Generated by Together */

package vglViewer;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import sdaz.SDAZDriver;
import java.awt.event.MouseEvent;
import sdaz.SDAZPoint;
import java.awt.Point;
import docViewPanel.DocViewPanel;

public class DocViewMouseHandler implements MouseHandler {
    public DocViewMouseHandler(SDAZDriver sdazDriver, DocViewPanel docViewPanel) {
        this.sdazState = new ListeningForSDAZMouse(sdazDriver);
        this.marqueeState = new ListeningForMarqueeMouse(docViewPanel);
        this.state = this.marqueeState;
    }

    public void listenForSDAZ() {
        this.state = this.sdazState;
    }

    public void listenForMarquee() {
        this.state = this.marqueeState;
    }

    public void mousePressed(MouseEvent e) {
        e.consume();
        state.mousePressed(e);

    }

    public void mouseReleased(MouseEvent e) {
        e.consume();
        state.mouseReleased(e);

    }

    public void mouseMoved(MouseEvent e) {
        e.consume();
        state.mouseMoved(e);

    }

   /* public void mouseDown(MouseEvent e) {
        state.mouseDown(e);
    }

    public void mouseUp(MouseEvent e) {
        state.mouseUp(e);
    }
*/

    public void mouseEntered(MouseEvent e) {
        e.consume();
        state.mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        e.consume();
        state.mouseExited(e);
    }

    public void mouseClicked(MouseEvent e) {
        e.consume();
        state.mouseClicked(e);
    }

    public void mouseDragged(MouseEvent e) {
        e.consume();
        state.mouseDragged(e);
    }

    /**
     * @supplierRole state
     * @supplierCardinality 1 
     */
    private MouseHandler state;

    /**
     * @link aggregationByValue
     * @clientCardinality 1
     * @supplierCardinality 1 
     */
    private ListeningForMarqueeMouse marqueeState;

    /**
     * @link aggregationByValue
     * @clientCardinality 1
     * @supplierCardinality 1 
     */
    private ListeningForSDAZMouse sdazState;
}