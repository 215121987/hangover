jQuery(document).ready(function (a) {
    function h(a, d) {
        a = escape(a);
        d = escape(d);
        var b = document.location.search, e = a + "=" + d, b = b.replace(new RegExp("(&|\\?)" + a + "=[^&]*"), "$1" + e);
        RegExp.$1 || (b += (0 < b.length ? "&" : "?") + e);
        return b
    }

    a(document).on("click", ".product a.compare", function (c) {
        c.preventDefault();
        var d = a(this);
        c = {_yitnonce_ajax:yith_woocompare.nonceadd, action:yith_woocompare.actionadd, id:d.data("product_id"), context:"frontend"};
        var b = a(".yith-woocompare-widget ul.products-list");
        d.block({message:null, overlayCSS:{background:"#fff url(" + woocommerce_params.ajax_loader_url + ") no-repeat center", backgroundSize:"16px 16px", opacity:.6}});
        b.block({message:null, overlayCSS:{background:"#fff url(" + woocommerce_params.ajax_loader_url + ") no-repeat center", backgroundSize:"16px 16px", opacity:.6}});
        a.ajax({type:"post", url:yith_woocompare.ajaxurl, data:c, dataType:"json", success:function (c) {
            d.unblock().addClass("added").text(yith_woocompare.added_label);
            b.unblock().html(c.widget_table);
            "yes" == yith_woocompare.auto_open && a("body").trigger("yith_woocompare_open_popup", {response:c.table_url, button:d})
        }})
    });
    a("body").on("yith_woocompare_open_popup", function (c, d) {
        var b = d.response;
        if (768 <= a(window).width())a.colorbox({href:b, iframe:0, width:"90%", height:"90%", onClosed:function () {
            var b = a(".yith-woocompare-widget ul.products-list"), c = {/*action:yith_woocompare.actionview,*/ context:"frontend"};
            b.block({message:null, overlayCSS:{background:"#fff url(" + woocommerce_params.ajax_loader_url + ") no-repeat center", backgroundSize:"16px 16px", opacity:.6}});
            a.ajax({type:"post", url:/*yith_woocompare.ajaxurl*/'/hangover/login.html?ajax=true', data:c, success:function (a) {
                b.unblock().html(a)
            }})
        }}), a(window).resize(function () {
            a.colorbox.resize({width:"90%", height:"90%"})
        }); else {
            var e = b.split("?");
            if (2 <= e.length) {
                for (var b = encodeURIComponent("iframe") + "=", f = e[1].split(/[&;]/g), g = f.length; 0 < g--;)-1 !== f[g].lastIndexOf(b, 0) && f.splice(g, 1);
                b = e[0] + "?" + f.join("&")
            }
            window.open(b, yith_woocompare.table_title)
        }
    });
    a(document).on("click", ".remove a", function (c) {
        c.preventDefault();
        var d = a(this);
        c = {_yitnonce_ajax:yith_woocompare.nonceremove, action:yith_woocompare.actionremove, id:d.data("product_id"), context:"frontend"};
        a("td.product_" + c.id + ", th.product_" + c.id);
        d.block({message:null, overlayCSS:{background:"#fff url(" + woocommerce_params.ajax_loader_url + ") no-repeat center", backgroundSize:"16px 16px", opacity:.6}});
        a.ajax({type:"post", url:yith_woocompare.ajaxurl, data:c, dataType:"html", success:function (b) {
            d.unblock();
            b = a(b).filter("table.compare-list");
            a("body > table.compare-list").replaceWith(b);
            a(window).trigger("yith_woocompare_product_removed")
        }})
    });
    a(".yith-woocompare-open a, a.yith-woocompare-open").on("click", function (c) {
        c.preventDefault();
        a("body").trigger("yith_woocompare_open_popup", {response:h("action", yith_woocompare.actionview) + "&iframe=true"})
    });
    a(".yith-woocompare-widget").on("click", "a.compare",
        function (c) {
            c.preventDefault();
            a("body").trigger("yith_woocompare_open_popup", {response:a(this).attr("href")})
        }).on("click", "li a.remove, a.clear-all", function (c) {
        c.preventDefault();
        var d = a(".yith-woocompare-widget .products-list").data("lang");
        c = a(this);
        var d = {_yitnonce_ajax:yith_woocompare.nonceremove, action:yith_woocompare.actionremove, id:c.data("product_id"), context:"frontend", responseType:"product_list", lang:d}, b = c.parents(".yith-woocompare-widget").find("ul.products-list");
        b.block({message:null, overlayCSS:{background:"#fff url(" + woocommerce_params.ajax_loader_url + ") no-repeat center", backgroundSize:"16px 16px", opacity:.6}});
        a.ajax({type:"post", url:yith_woocompare.ajaxurl, data:d, dataType:"html", success:function (a) {
            b.html(a);
            b.unblock()
        }})
    })
});