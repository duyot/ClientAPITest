package com.wms.dto;

import java.util.List;

/**
 * Created by duyot on 11/3/2016.
 */
public class ActionMenuDTO {
    private ActionDTO parentAction;
    private List<ActionDTO> lstSubAction;

    public ActionMenuDTO(ActionDTO parentAction, List<ActionDTO> lstSubAction) {
        this.parentAction = parentAction;
        this.lstSubAction = lstSubAction;
    }

    public ActionMenuDTO() {
    }

    public ActionDTO getParentAction() {
        return parentAction;
    }

    public void setParentAction(ActionDTO parentAction) {
        this.parentAction = parentAction;
    }

    public List<ActionDTO> getLstSubAction() {
        return lstSubAction;
    }

    public void setLstSubAction(List<ActionDTO> lstSubAction) {
        this.lstSubAction = lstSubAction;
    }
}
