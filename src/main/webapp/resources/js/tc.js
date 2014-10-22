String.prototype.endsWith = function(suffix) {
    return this.indexOf(suffix, this.length - suffix.length) !== -1;
};

(function($, TC) {
	$.extend(TC, {
		URL: {
			clearTrafficNics: "/tc/clearTrafficNics",
			preSetupTrafficNics: "/tc/preSetupTrafficNics",
			limitTrafficFromIp: "/tc/limitTrafficFromIp",
			unlimitTrafficFromIp: "/tc/unlimitTrafficFromIp",
			limitTrafficToIp: "/tc/limitTrafficToIp",
			unlimitTrafficToIp: "/tc/unlimitTrafficToIp",
			execSimpleScript: "/tc/execSimpleScript"
		},
		IDS:{
			pstnNic: "pstnNic",
			pstnStart: "pstnStart",
			pstnStop: "pstnStop",
			pstnStep: "pstnStep",
			ltfiIp: "ltfiIp",
			ltfiBw: "ltfiBw",
			ultfiIp: "ultfiIp",
			ultfiBw: "ultfiBw",
			lttiIp: "lttiIp",
			lttiBw: "lttiBw",
			ulttiIp: "ulttiIp",
			ulttiBw: "ulttiBw",
			script: "script"
		},
		ajaxRequest: function(url, data){
			$.ajax({
				url: _root + url,
				type: "get", 
				dataType: "json",
				data: data,
				success: function (response, textStatus, XMLHttpRequest) {
					alert(response.errorCode+","+response.description);
		        }
		    });
		},
		clearTrafficNics : function() {
			this.ajaxRequest(TC.URL.clearTrafficNics,{});
			return false;
		},
		preSetupTrafficNics : function() {
			this.ajaxRequest(TC.URL.preSetupTrafficNics,{
				"nicName": $("#"+TC.IDS.pstnNic).val(),
				"start": $("#"+TC.IDS.pstnStart).val(),
				"end": $("#"+TC.IDS.pstnStop).val(),
				"step": $("#"+TC.IDS.pstnStep).val()
			});
			return false;
		},
		limitTrafficFromIp : function() {
			this.ajaxRequest(TC.URL.limitTrafficFromIp,{
				"fromIp":$("#"+TC.IDS.ltfiIp).val(),
				"bandwidth":$("#"+TC.IDS.ltfiBw).val()
			});
			return false;
		},
		unlimitTrafficFromIp : function() {
			this.ajaxRequest(TC.URL.unlimitTrafficFromIp,{
				"fromIp":$("#"+TC.IDS.ultfiIp).val(),
				"bandwidth":$("#"+TC.IDS.ultfiBw).val()
			});
			return false;
		},
		limitTrafficToIp : function() {
			this.ajaxRequest(TC.URL.limitTrafficToIp,{
				"toIp":$("#"+TC.IDS.lttiIp).val(),
				"bandwidth":$("#"+TC.IDS.lttiBw).val()
			});
			return false;
		},
		unlimitTrafficToIp : function() {
			this.ajaxRequest(TC.URL.unlimitTrafficToIp,{
				"toIp":$("#"+TC.IDS.ulttiIp).val(),
				"bandwidth":$("#"+TC.IDS.ulttiBw).val()
			});
			return false;
		},
		execSimpleScript : function() {
			this.ajaxRequest(TC.URL.execSimpleScript,{
				"command": $("#"+TC.IDS.script).val()
			});
			return false;
		}
	});
})(window.jQuery, window.TC ? window.TC : window.TC = {});