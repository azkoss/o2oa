MWF.xDesktop.requireApp("process.Xform", "$Module", null, false);
MWF.require("MWF.widget.Tab", null, false);
MWF.xApplication.process.Xform.Tab = MWF.APPTab =  new Class({
	Extends: MWF.APP$Module,

	_loadUserInterface: function(){
        this.elements = [];
        this.containers = [];

        var style = "form";
        if (layout.mobile) style = "mobileForm";

		this.tab = new MWF.widget.Tab(this.node, {"style": style});
		
		this._setTabWidgetStyles();
		
		this.tab.tabNodeContainer = this.node.getFirst("div");
		this.tab.contentNodeContainer = this.node.getLast("div");
		this.tab.load();
		
		var tabs = this.tab.tabNodeContainer.getChildren("div");
		var contents = this.tab.contentNodeContainer.getChildren("div");
		tabs.each(function(tab, idx){
			
			this.tab.rebuildTab(contents[idx], contents[idx].getFirst(), tab);
		}.bind(this));
		
		this.tab.pages[0]._showTab();
        this.loadSubModule();
	},
    loadSubModule: function(){
        this.tab.pages.each(function(page){
            var node = page.tabNode;
            var json = this.form._getDomjson(node);
            var tab = this;
            var module = this.form._loadModule(json, node, function(){
                this.tab = tab;
            });
            this.elements.push(module);
            this.form.modules.push(module);

            node = page.contentNode;
            json = this.form._getDomjson(node);
            tab = this;
            module = this.form._loadModule(json, node, function(){
                this.tab = tab;
            });
            this.containers.push(module);
            this.form.modules.push(module);

        }.bind(this));
    },

	_setTabWidgetStyles: function(){
        if (this.json.tabNodeContainer) this.tab.css.tabNodeContainer = this.json.tabNodeContainer;
        if (this.json.contentNodeContainer) this.tab.css.contentNodeContainer = this.json.contentNodeContainer;
		this.tab.css.tabNode = this.json.tabStyles;
		this.tab.css.tabTextNode = this.json.tabTextStyles;
		this.tab.css.tabNodeCurrent = this.json.tabCurrentStyles;
		this.tab.css.tabTextNodeCurrent = this.json.tabTextCurrentStyles;
	}
}); 