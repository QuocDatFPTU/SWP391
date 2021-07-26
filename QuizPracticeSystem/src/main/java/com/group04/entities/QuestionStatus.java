
package com.group04.entities;
// BLO Business Logic Object: de handle logic tam thoi ko lien quan den DB
import java.io.Serializable;

/**
 *
 * @author Polaris
 */
public class QuestionStatus implements Serializable{
   private boolean marked;
   private Option chosenOption;

    public QuestionStatus() {
    }

    public QuestionStatus(boolean marked, Option chosenOption) {
        this.marked = marked;
        this.chosenOption = chosenOption;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public Option getChosenOption() {
        return chosenOption;
    }

    public void setChosenOption(Option chosenOption) {
        this.chosenOption = chosenOption;
    }
}
