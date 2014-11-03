/**
 * Created by atanasWin on 1/7/2014.
 */
var NAVBAR = {
    lastId : "menu-item-home",
    chooseMenuItem : function(id) {
        if (id == this.lastId) {
            return;
        } else {
            this.hideContent(this.getContentId(this.lastId));
            this.showContent(this.getContentId(id));
            this.lastId = id;
        }
    },
    getContentId : function(id) {
        var contentId;
        switch (id) {
            case "menu-item-home" :
                contentId = "home-content";
                break;
            case "menu-item-become-designer" :
                contentId = "become-designer-content";
                break;
            case "menu-item-about" :
                contentId = "about-content";
                break;
        }
        return contentId;
    },
    hideContent : function(id) {
        var contentDiv = document.getElementById(id);
        contentDiv.style.display = "none";
    },
    showContent : function(id) {
        var contentDiv = document.getElementById(id);
        contentDiv.style.display = "block";
    }
};

window.onload = function() {
}


