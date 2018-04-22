"use strict";
!function () {
    var r = 0;
    window.onerror = function (n, t, e, o, a) {
        try {
            var c = "Script error";
            if (r >= 2 || a && a.sc || "string" == typeof n && (n == c || n == c + ".")) return !0;
            r++;
            var s = "";
            a && a.name ? s += a.name + ": " + a.message + (a.stack ? "\n" + a.stack : "") : s = n, s = s.substr(0, 800);
            var i = document.location, u = window.encodeURIComponent;
            "function" == typeof u && (s = u(s),
                t = u(t), e = u(e), i = u(i));
            var m = new Image;
            m.src = "/_/je?m=" + s + "&u=" + t + "&l=" + e + "&p=" + i + "&r=" + (Math.random() + "").substr(2);
        } catch (f) {
        }
        return !0
    }
}();

function Array_from(e) {
    if (!e) return [];
    if ("undefined" != typeof e.toArray) return e.toArray();
    for (var t = [], n = 0; n < e.length; n++) t.push(e[n]);
    return t
}

function bindFunc() {
    var e = Array_from(arguments), t = e.shift(), n = e.shift();
    return function () {
        return t.apply(n, e.concat(Array_from(arguments)))
    }
}

function trimSpace(e) {
    return e.replace(/^\s+/, "").replace(/\s+$/, "")
}

function getScrollXY() {
    if (env.frame && parent && parent != window) {
        var e = parent.getScrollXY();
        if (e[0] || e[1] || env.ios < 15) return e
    }
    var t = 0, n = 0, r = document.documentElement, i = document.body;
    return void 0 !== window.pageYOffset ? (t = window.pageXOffset, n = window.pageYOffset) : r && (r.scrollLeft || r.scrollTop) ? (t = r.scrollLeft,
        n = r.scrollTop) : i.parentNode && (i.parentNode.scrollLeft || i.parentNode.scrollTop) ? (t = i.parentNode.scrollLeft,
        n = i.parentNode.scrollTop) : (t = i.scrollLeft, n = i.scrollTop), [t, n]
}

function window_size() {
    if (env.frame && parent && parent != window) {
        var e = parent.window_size();
        if (e[0] || e[1]) return e;
    }
    var t = 630, n = 460, r = document.documentElement, i = document.body;
    return window.env && env.operaMini ? (t = window.screen.width,
        n = window.screen.height) : window.innerWidth ? (t = window.innerWidth, n = window.innerHeight) : r && r.clientWidth ? (t = r.clientWidth,
        n = r.clientHeight) : i.parentNode && i.parentNode.clientWidth ? (t = i.parentNode.clientWidth,
        n = i.parentNode.clientHeight) : i.clientWidth && (t = i.clientWidth, n = i.clientHeight), [t, n];
}

function fireEvent(e, t) {
    var n;
    document.createEvent ? (n = document.createEvent("HTMLEvents"),
        n.initEvent(t, !0, !0), e.dispatchEvent(n)) : (n = document.createEventObject(), n.eventType = t,
        n.eventName = t, e.fireEvent("on" + n.eventType, n))
}

function submitForm(e) {
    fireEvent(e, "submit"),
        e.submit()
}

function getTouchEvent(e) {
    return e.changedTouches ? e.changedTouches[0] : e.targetTouches ? e.targetTouches[0] : e.touches ? e.touches[0] : e.pageX || e.pageY ? e : void 0;
}

function _eventHandler(e) {
    if (e) {
        if (!e.target) try {
            e.srcElement && (e.target = e.srcElement);
        } catch (t) {
        }
        if ("undefined" == typeof e.pageX && ("mousemove" == e.type || "mousedown" == e.type || "mouseup" == e.type)) try {
            var n = getScrollXY();
            e.pageX = n[0], e.pageY = n[1], (e.clientX || e.clientY) && (e.pageX += e.clientX,
                e.pageY += e.clientY)
        } catch (t) {
        }
        e.preventDefault || (e.preventDefault = function () {
            window.event && (window.event.returnValue = !1);
        }), e.stopPropagation || (e.stopPropagation = function () {
            window.event && (window.event.cancelBubble = !0);
        });
        var r = this[1].call(this[0], e);
        return r === !1 && e.preventDefault(), r
    }
}

function addEventListenerX(e, t, n, r, i) {
    if (e) {
        i = i || {}, e.js_events || (e.js_events = {}), "object" != typeof r || eventSupportsOptions || (r = r.capture),
            r = r || !1;
        var o = null;
        return e.addEventListener ? e.addEventListener(t, o = bindFunc(_eventHandler, [e, n, i]), r) : e.attachEvent && e.attachEvent("on" + t, o = bindFunc(_eventHandler, [e, n, i])),
        e.js_events[t] || (e.js_events[t] = []), e.js_events[t].push([o, r]), o
    }
}

function removeEventListenerX(e, t, n, r, i) {
    if (e) {
        var o = -1;
        if ("undefined" == typeof r && e.js_events && e.js_events[t]) for (var s = 0, a = e.js_events[t].length; a > s; s++) {
            var l = e.js_events[t][s];
            if (l[0] == n) {
                r = l[1], o = s;
                break
            }
        }
        if (e.removeEventListener ? e.removeEventListener(t, n, r || !1) : e.detachEvent && e.detachEvent("on" + t, n),
            !i && e.js_events && e.js_events[t]) {
            if (-1 == o) for (var s = 0, a = e.js_events[t].length; a > s; s++) {
                var l = e.js_events[t][s];
                if (l[0] == n) {
                    o = s;
                    break
                }
            }
            o >= 0 && e.js_events[t].splice(s, 1)
        }
    }
}

function purgeEventListeners(e, t) {
    if ("undefined" != typeof e.js_events) {
        if (e.js_events[t]) {
            for (var n = 0, r = e.js_events[t].length; r > n; n++) {
                var i = e.js_events[t][n];
                removeEventListenerX(e, t, i[0], i[1], !0);
            }
            e.js_events[t] = []
        }
        e["on" + t] && (e["on" + t] = null)
    }
}

function purgeAllEventListeners(e) {
    if ("undefined" != typeof e.js_events) {
        for (var t in e.js_events) for (var n = 0, r = e.js_events[t].length; r > n; n++) {
            var i = e.js_events[t][n];
            removeEventListenerX(e, t, i[0], i[1], !0)
        }
        e.js_events = {}
    }
}

function $(e, t) {
    return t = t || document, "string" != typeof e ? e : "." == e[0] ? t.getElementsByClassName ? t.getElementsByClassName(e.substr(1)) : t.querySelectorAll ? t.querySelectorAll(e) : window.getElementsByClassName ? getElementsByClassName(e.substr(1), "*", t) : [] : "[" == e[0] ? t.querySelectorAll ? t.querySelectorAll(e) : window.getElementsByAttribute ? getElementsByAttribute(e, "*", t) : [] : document.getElementById(e);
}

function $$(e) {
    var t = env.fr;
    if (!t) return $(e);
    if ("undefined" != typeof t.contentWindow && t.contentWindow && "undefined" != typeof t.contentWindow.$) return t.contentWindow.$(e);
}

function createElement(e, t, n) {
    var r = document.createElement(e);
    if ("object" == typeof t) for (var i in t) setAttribute(r, i, t[i]);
    if ("object" == typeof n) {
        if (n.nodeType) r.appendChild(n); else if (n.length) for (var o = 0; o < n.length; o++) "string" == typeof n[o] ? r.appendChild(document.createTextNode(n[o])) : r.appendChild(n[o]);
    } else "string" == typeof n && (r.innerHTML = n);
    return r
}

function removeElement(e) {
    e && e.parentNode && e.parentNode.removeChild(e);
}

function getAttribute(e, t) {
    return e && t ? "function" == typeof e.getAttribute ? e.getAttribute(t) : "undefined" != typeof e[t] ? e[t] : e.attributes && e.attributes[t] ? e.attributes[t] : void 0 : void 0;
}

function setAttribute(e, t, n) {
    if (e) {
        if ("style" == t && env.msie < 9) return void(e.cssText = n);
        "class" == t && (e.className = n), "value" != t && "function" == typeof e.setAttribute ? e.setAttribute(t, n) : e[t] = n;
    }
}

function elementReverseChildren(e, t) {
    if (t = t || 1, e && e.childNodes) for (var n = e.childNodes, r = 0; r < n.length; r++) {
        var i = n[n.length - 1];
        ("DIV" == i.tagName || "A" == i.tagName) && (e.insertBefore(i, n[r]), 2 > t && elementReverseChildren(i, t + 1));
    }
}

function elementRemoveA() {
    var e = $("_a_1");
    e && (e.innerHTML = ""), e = $("_a_2"), e && (e.innerHTML = ""),
        e = $("_a_3"), e && (e.innerHTML = "")
}

function getStyle(e, t) {
    if (e && t && e.style) {
        if (window.getComputedStyle) {
            var n = window.getComputedStyle(e, "");
            if (n) return n.getPropertyValue(t)
        }
        return e.currentStyle ? e.currentStyle[t] : e.style[t];
    }
}

function cssStylesAdd(e, t) {
    var n = crel("style", {type: "text/css"});
    t && (removeElement($(t)),
        n.id = t), n.styleSheet ? n.styleSheet.cssText = e : n.appendChild(document.createTextNode(e));
    var r = document.body || document.getElementsByTagName("HEAD")[0];
    return r.appendChild(n),
        n
}

function setStyleProperty(e, t, n, r) {
    e && t && e.style && (e.style[t] = n, r && e.style.setProperty && e.style.setProperty(t, n, r));
}

function cssTransition(e, t) {
    if (e) {
        var n = e.style;
        n.mozTransition = t, n.webkitTransition = t,
            n.transition = t
    }
}

function cssTransform(e, t) {
    if (e) {
        var n = e.style;
        n.mozTransform = t, n.webkitTransform = t,
            n.transform = t
    }
}

function hasClassName(e, t) {
    return e && t ? new RegExp("\\b" + t + "\\b").test(e.className) : void 0;
}

function addClassName(e, t) {
    return e && t && !hasClassName(e, t) ? void(e.className = e.className + " " + t) : !1;
}

function removeClassName(e, t) {
    if (e && t && e.className) {
        for (var n = "", r = e.className.split(" "), i = 0; i < r.length; i++) r[i] != t && (n += r[i] + " ");
        e.className = n.slice(0, -1)
    }
}

function toggle_display(e) {
    e && ("none" == getStyle(e, "display") ? e.style.display = "block" : e.style.display = "none");
}

function userProfileNameUpdate(e) {
    var t = (env.frame ? parent : window).$("mainbarUsernameLink");
    t && (t.innerHTML = htmlspecialchars(e))
}

function settingsLocalGet(e) {
    var t = cookieGet("sl");
    if (!t) return 0;
    t = t.split(":");
    for (var n = t.length - t.length % 2, r = 0; n > r; r += 2) if (t[r] == e) return t[r + 1];
    return 0
}

function settingsLocalSave(e, t) {
    var n = cookieGet("sl"), r = {};
    if (n) {
        n = n.split(":");
        for (var i = n.length - n.length % 2, o = 0; i > o; o += 2) r[n[o]] = n[o + 1]
    }
    r[e] = t;
    var t = "";
    for (var o in r) t && (t += ":"),
        t += o + ":" + r[o];
    var s = new Date;
    s.setMonth(s.getMonth() + 6), document.cookie = "sl=" + t + "; path=/; secure; expires=" + s.toGMTString();
}

window.Qtv = function (e) {
    return e = e || {m: {}, mF: {}}, e.moduleAdd = function (t, n) {
        if (!e.m[t] && (e.m[t] = {},
            n && n(), e.mF[t])) {
            for (var r in e.mF[t]) e.mF[t][r]();
            delete e.mF[t]
        }
    }, e.f = function (t, n) {
        return e.m[t] ? (n(), !0) : (e.mF[t] || (e.mF[t] = []), e.mF[t].push(n), !1)
    }, e
}(window.Qtv),
"undefined" == typeof console && (console = {
    log: function () {
    }
});
var eventSupportsOptions = !1;
!function () {
    try {
        var e = Object.defineProperty({}, "capture", {
            get: function () {
                eventSupportsOptions = !0;
            }
        });
        window.addEventListener("test", null, e)
    } catch (t) {
    }
}();
var crel = createElement, settingsLocalMenuHidden = 1, settingsLocalMenuVisible = 2, settingsLocalChatVisible = 4,
    settingsLocalNightMode = 8, settingsLocalMainbarBottom = 32, settingsLocalMainbarTop = 64,
    settingsLocalMainbarAutoHide = 128, settingsLocalNotifSound = 512, settingsLocalChatOverlayHide = 2048,
    settingsLocalNotifOverlayHide = 4096, user_cmt_last = {}, user_cmt_first = {}, cmt_last = {}, cmt_first = {};

function userAgentStop() {
    try {
        window.stop ? window.stop() : document.execCommand && document.execCommand("Stop");
    } catch (e) {
    }
}

function cookiesGet() {
    for (var e = document.cookie.split(/; ?/), n = {}, t = 0; t < e.length; t++) {
        var a = e[t].match(/^([^=]+)=(.+)/);
        a && (n[a[1]] = a[2])
    }
    return n
}

function cookieGet(e) {
    e += "=";
    for (var n = document.cookie.split(/; ?/), t = 0; t < n.length; t++) if (n[t].slice(0, e.length) == e) return n[t].slice(e.length);
}

function localStorageErrored() {
    localStorageError = !0;
    try {
        localStorage.clear && localStorage.clear();
    } catch (e) {
    }
}

function elementSlideOpen(e, n) {
    e && (e.style.display = "block", n && n())
}

function elementSlideClose(e, n, t) {
    e && (e.style.display = "none", n && n())
}

function nightModeEnabled() {
    return hasClassName(document.body, "nightMode");
}

function nightModeToggle(e, n) {
    "undefined" == typeof n && (n = !hasClassName(document.body, "nightMode"));
    var t = env.fr;
    if (t) {
        var a = t.contentWindow;
        a && a.nightModeToggle(e, n)
    }
    var i = cssStylesAdd("*{transition:none!important}");
    setTimeout(function () {
        removeElement(i)
    }, 500), n ? (addClassName(document.body, "nightMode"),
    e || settingsLocalSave(1, settingsLocalGet(1) | settingsLocalNightMode)) : (removeClassName(document.body, "nightMode"),
    e || settingsLocalSave(1, settingsLocalGet(1) & ~settingsLocalNightMode));
    var o = $("nightModeStatus");
    if (o && (o.innerHTML = n ? "On" : "Off"), window.CKEDITOR) for (var r in CKEDITOR.instances) nightModeHtmlEditor(CKEDITOR.instances[r], !0);
}

function pageNavAddStorage(e) {
    try {
        "undefined" != typeof window.localStorage && (window.localStorage.lu = pageFrameUrlFix(e, !0, !0, !0));
    } catch (n) {
        localStorageErrored()
    }
}

function pageNavGetStorage() {
    try {
        if (window.localStorage && window.localStorage.lu) return window.localStorage.lu;
    } catch (e) {
    }
}

function standaloneInit() {
    var e = $("mainMenuCopyLink");
    e && (e.style.display = "block");
    var n = null;
    if (env.ios != env.BROWSER_NOT_FOUND && (env.ios < 9 || env.ios >= 9.2) && env.ios < 11 && (n = crel("div", {
            id: "iosHeaderBar"
        }), document.body.appendChild(n)), !cookieGet("safl")) {
        if (document.cookie = "safl=1; path=/",
            env.ios != env.BROWSER_NOT_FOUND) {
            var t = cssStylesAdd("#chat_num{display:none!important}");
            setTimeout(function () {
                removeElement(t)
            }, 500)
        }
        var a = pageNavGetStorage();
        if (a && a.replace(/[\?#].*$/, "") != pageFrameUrlFix(location.href, !0, !0, !0).replace(/[\?#].*$/, "")) return pageNavUnload(),
            pageNavPrevLoad = !0, cssStylesAdd("#container{display:none!important}"), window.pageNavigate ? pageNavigate(a, {
            noState: !0, noDialog: !0
        }) : location.replace(a), void setTimeout(function () {
            removeElement($("container"));
        }, 100);
        pageNavPrevLoad = !0, setTimeout(function () {
            pageNavPrevLoad = !1
        }, 300)
    }
    pageNavAddStorage(location.href);
}

function scInit() {
    function e(e, t) {
        ("*" == e || e && e.match(/iframe/i)) && n(t + " " + e, 1)
    }

    function n(e, n) {
        if (i++, !(i > 10)) {
            try {
                throw new Error(a + e.substr(0, 120))
            } catch (t) {
                if (window.onerror("", "", 0, 0, t),
                    n && !t.stack && t.stack.match(/culateNewProcess|finder-all-fra|r\/js\/adrn/)) return
            }
            var o = new Error;
            throw o.sc = 1, o
        }
    }

    function t(e, t) {
        e.tagName && "script" == e.tagName.toLowerCase() && e.src && !d.test(e.src) && n(t + " " + e.src);
    }

    if (!(document._getElementsByTagName || env.operaMini || env.mobile && env.android == env.BROWSER_NOT_FOUND && env.ios == env.BROWSER_NOT_FOUND)) {
        var a = "4e92a7e2 ", i = 0, o = document;
        try {
            o._getElementsByTagName = o.getElementsByTagName,
                o.getElementsByTagName = function (n) {
                    return e(n, "n"), this._getElementsByTagName(n)
                },
            o.querySelectorAll && !o._querySelectorAll && (o._querySelectorAll = o.querySelectorAll,
                o.querySelectorAll = function (n) {
                    return e(n, "a"), this._querySelectorAll(n)
                })
        } catch (r) {
        }
        var d = /^https?:\/\/([^\/]*\.|)(quotev\.com|google(apis|syndication|)\.(com|co\.uk|ca)|(doubleclick|2mdn)\.net)\//i,
            l = function (e, n) {
                return t(e, "i"), this._insertBefore(e, n)
            }, s = function (e) {
                return t(e, "c"), this._appendChild(e);
            }, c = o.getElementsByTagName("head")[0] || o.head;
        if (!c._insertBefore) try {
            c._insertBefore = c.insertBefore,
                c.insertBefore = l, c._appendChild = c.appendChild, c.appendChild = s
        } catch (r) {
        }
    }
}

function scInit2() {
    try {
        var e = document, n = e.getElementsByTagName("head")[0] || e.head, t = e.body;
        if (!n._insertBefore || t._insertBefore) return;
        t._getElementsByTagName = t.getElementsByTagName, t.getElementsByTagName = e.getElementsByTagName,
        t.querySelectorAll && (t._querySelectorAll = t.querySelectorAll, t.querySelectorAll = e.querySelectorAll),
        t.insertBefore != n.insertBefore && (t._insertBefore = t.insertBefore, t.insertBefore = n.insertBefore,
            t._appendChild = t.appendChild, t.appendChild = n.appendChild)
    } catch (a) {
    }
}

function pageNavPreInit() {
    navHistoryUrlHashParse(), env.title = document.title, navigator.standalone && env.ios != env.BROWSER_NOT_FOUND && (env.ios < 9 || env.ios >= 9.2) && env.ios < 11 && (mainbarSizeAdd = 20),
        mainbarBottom = mainbarBottomEnabled(), mainbarBottomCss();
    var e = !1;
    if (parent == window) e = !0; else try {
        "undefined" == typeof parent.pagesLoaded && (e = !0)
    } catch (n) {
        e = !0
    }
    if (e) return env.frame ? (env.frame = 0,
        window.onbeforeunload = null, void top.location.replace(pageFrameUrlFix(location.href, !0))) : (pageNavFirstPage = location.href,
    env.historySupport && location.href.match(/[&\?]_nv[hs]/) && history.replaceState(history.state, document.title, pageFrameUrlFix(location.href, !0)),
        Qtv.f("nav-scroll", function () {
            navScrollPreInit()
        }), Qtv.f("nav-state", function () {
        navStatePreInit();
    }), void(env.r.mobile && env.android != env.BROWSER_NOT_FOUND && cssStylesAdd("#chat_num { padding-top: 6px; }")));
    if (env.frame = !0, parent.env.k = env.k, parent.env.mainMenuHide = env.mainMenuHide, parent.env.hideHeader = env.hideHeader,
            parent.env.hideHeaderManual = env.hideHeaderManual, parent.env.notifDisable = env.notifDisable,
            parent.env.title = document.title, parent.document.title = document.title, parent.act_n_c = 0,
            parent.pageNavListSelected = void 0, window.addEventListener("unload", function () {
            pageNavUnload();
        }), env.ios >= 14 && addEventListenerX(window, "scroll", function () {
            fireEvent(parent, "scroll");
        }), parent.pageFrameOld && (parent.pageFrameOldRemove(parent.pageFrameOld), parent.pageFrameOld = 0),
            cssStylesAdd("#mainbar,#mainbarBackLayer{display:none!important}#mainMenu{display:none!important}body{background-color:transparent!important;background-image:none!important;padding-left:" + (parent.document.body.style.paddingLeft || "0") + "}"),
            env.historySupport) {
        if (location.href.match(/[&\?]_ifx|_nv[hs]/)) {
            var t = history.state || {};
            location.href.match(/_ifx/) && (t._ifx = 1), history.replaceState(t, document.title, pageFrameUrlFix(location.href, !0));
        }
        if (env.mobile || !parent.pageNavSkipState) {
            var t = parent.history.state || {};
            t._ifx = 1,
                t._ils = 0, env.mobile ? parent.history.replaceState(t, document.title, pageFrameUrlFix(location.href, !0)) : parent.history.pushState(t, document.title, pageFrameUrlFix(location.href, !0));
        }
    }
    pageNavScrollInit(), parent.pageNavSkipState || parent.pageNavPrevLoad || textInputSaveDelete(),
    parent.env.r.u != env.r.u && (window.onbeforeunload = null, top.location.replace(pageFrameUrlFix(location.href)));
}

function pageNavContainerCheck() {
    var e = $("container");
    return e ? (removeElement(pageNavInitContainerOpacity),
        pageNavInitContainerOpacity = null, void(e.style.opacity = 1)) : void setTimeout(pageNavContainerCheck, 50);
}

function pageNavInit() {
    function e() {
        var e = window_size();
        if (e[1] < e[0]) {
            if (env.orientation = "landscape",
                    i) {
                i.style.display = "none", mainbarSizeAdd = mainbarSizeAdd2;
                var n = "div.pProfileContainer{margin-top:0px}span.cke_top{border-top:0}";
                n += mainbarBottom ? ".elementSlide,.fixedMenu,#chatc,#chl,#notif_list,#searchMenu,#containerLoading,div.ch_w,div.navHeaderContainer{top:0px!important}#container{padding-top:50px!important}" : ".elementSlide,.fixedMenu,#chatc,#chl,#notif_list,#searchMenu,#containerLoading,div.ch_w,div.navHeaderContainer{top:" + mainbarHeight + "px!important}#container{padding-top:" + (50 + mainbarHeight + mainbarSizeAdd) + "px!important}",
                    cssStylesAdd(n, "iosHeaderHideStyle")
            }
        } else env.orientation = "portrait", i && (i.style.display = "block",
            mainbarSizeAdd = 20 + mainbarSizeAdd2, removeElement($("iosHeaderHideStyle")))
    }

    if (env.frame) pageFrameInit(); else {
        env.ios != env.BROWSER_NOT_FOUND && (pageWidthPortrait = window.screen.width, pageWidthLandscape = window.screen.height),
        mainbarBottom && mainbarBottomRenderUpdate(), navigator.standalone && standaloneInit();
        try {
            if (pageNavScrollInit(), env.historySupport) {
                var n = location.href;
                navigator.standalone && !n.match(/[\?&]_slfl([&#]|$)/) && (n = urlAddParam(n, "_slfl"));
                var t = history.state || {};
                t._ifx = 1, t._ils = 0, history.replaceState(t, document.title, n);
            }
        } catch (a) {
        }
        if ((env.ios != env.BROWSER_NOT_FOUND || navigator.standalone) && Qtv.f("nav-load", function () {
                setTimeout(pageNavProgressInit)
            }), env.mobile) {
            var i = $("iosHeaderBar");
            window.addEventListener && window.addEventListener("resize", e),
                e(), env.UCWeb ? cssStylesAdd("#mainbar{width:800px;background-color:#222;overflow:hidden}#mainMenuBtn *,#editorMenuButton *{padding:0 3px!important;margin:0!important;height:auto!important;border:0!important}#homeIcon,#quizIcon,#storyIcon,#activityIcon,#createIcon,#profileIcon,#settingsIcon,#logoutIcon,#recentIcon,#notif_i{background-size:48px;width:48px;height:48px}#menuSearchBtn{background:none!important;color:#888}.qbutton_small,.qbutton{width:100px!important}div.dlg_pop{position:static!important}div.profileHeader div.overlay{display:none!important}") : env.operaMini && cssStylesAdd('#mainbar{position:absolute}.select::after{display:none;content:""}div.activity .qbutton_small,.activity_comments .qbutton_small,div.user_comment_replies .qbutton_small,.quizComment .qbutton_small{position:absolute;right:3px}#quiz_questions_loading{visibility:hidden}div.profileBody>.sectionSelect .inner{white-space:normal!important}');
        }
        env.gTranslate && cssStylesAdd("#homeIcon,#quizIcon,#storyIcon,#activityIcon,#createIcon,#profileIcon,#settingsIcon,.loginBtn,#mainbarBackLayer{display:none}" + (env.fixedPositioning ? "" : "#mainbar{top:100px!important} #mainMenu{top:145px!important}"));
    }
    env.modern && env.ios >= 8 && env.mobile && (pageNavInitContainerOpacity = cssStylesAdd("#container { opacity: 0; }"),
        setTimeout(pageNavContainerCheck, 50)), navigator.standalone && env.ios != env.BROWSER_NOT_FOUND && Qtv.f("element-selection", function () {
        document.addEventListener("keydown", userAgentFocusActive)
    }), Qtv.f("nav-keyboard", function () {
        navKeyboardInit()
    })
}

function navHistoryUrlHashParse() {
    if (window.JSON) {
        var e = location.search.match(/[\?&]_nvs=([^&#]+)([&#]|$)/);
        if (e && (pageNavLoadScrollTo = parseInt(decodeURIComponent(e[1]))), env.r.nvh) try {
            return void(navHistory = JSON.parse(env.r.nvh));
        } catch (n) {
        }
        if (e = location.search.match(/[\?&]_nvh=([^&#]+)([&#]|$)/)) {
            var t = decodeURIComponent(e[1]);
            try {
                navHistory = JSON.parse(t)
            } catch (n) {
            }
        }
    }
}

function mainbarBottomCss() {
    if (mainbarBottomCssElem && (removeElement(mainbarBottomCssElem),
            mainbarBottomCssElem = null), !mainbarBottom) return removeClassName(document.documentElement, "mainbarBottom"),
        void(env.ios != env.BROWSER_NOT_FOUND && (mainbarBottomCssElem = navigator.standalone ? cssStylesAdd("span.cke_top{border-top:22px solid #eee}.fixedMenu,#chatc,#chl,#notif_list,#searchMenu,#containerLoading,div.ch_w,div.navHeaderContainer{top:73px!important}#container{padding-top:" + (105 + mainbarSizeAdd) + "px}#mainbar{border-top:20px solid #222}") : cssStylesAdd("#footerPadding{height:50px}")));
    addClassName(document.documentElement, "mainbarBottom");
    var e = "#mainbar{top:auto;z-index:400000;bottom:0px!important}#mainbarBackLayer{top:inherit;bottom:0px!important}#footerPadding{height:" + mainbarHeight + 'px}div.drop_links::after{content:" ";display:block;height:' + mainbarHeight + "px;background:transparent!important;box-shadow:none!important}#searchMenu{padding-top:100px}#mainMenuFooter{padding-top:500px}.fixedMenu," + (env.r.mobile ? "#chatc,div.ch_w," : "") + "#chl,#notif_list,#searchMenu,#containerLoading,div.navHeaderContainer{top:" + mainbarSizeAdd + "px!important}#container{padding-top:" + (50 + mainbarSizeAdd) + "px!important}.fixedMenu{margin-bottom:" + (mainbarHeight + mainbarSizeAdd) + "px!important}#mainMenu>a:last-child,.infoMessage{margin-bottom:" + (mainbarHeight + mainbarSizeAdd + 5) + "px!important}#login_sh{margin-top:" + (mainbarSizeAdd + 5) + "px!important}div.pProfileContainer{margin-top:" + mainbarSizeAdd + "px!important;padding-bottom:" + mainbarHeight + "px!important}#container div.pProfileContainer{margin-top:" + -1 * mainbarHeight + "px!important}";
    e += env.mobile ? "#notif_msg,#chatMsgNotif{bottom:" + (mainbarHeight + 20) + "px!important}div.profileHeaderInner{padding-top:48px}div.profileHeader div.overlay{height:480px!important}" : "#searchArea{bottom:10px}#menuSearchBtn2{margin-top:-24px;top:0}#notif_msg,#chatMsgNotif{top:8px!important}",
    mainbarSizeAdd > 0 && (e += "span.cke_top{border-top:" + (mainbarSizeAdd + 2) + "px solid rgba(100,100,100,.4)!important}"),
        mainbarBottomCssElem = cssStylesAdd(e)
}

function mainbarBottomRenderUpdate() {
    var e = $("mainMenu");
    e && (elementReverseChildren(e), e.style.top = mainbarBottom ? 0 : mainbarHeight + "px", e.scrollTop = mainbarBottom ? 1e4 : 0),
        e = $("chl"), e && (e.style.top = mainbarBottom ? 0 : mainbarHeight + "px"), e = $("notif_list"),
    e && (e.style.top = mainbarBottom ? 0 : mainbarHeight + "px")
}

function mainbarBottomEnabled() {
    if (!env.fixedPositioning) return !1;
    var e = settingsLocalGet(1) || 0;
    return e & settingsLocalMainbarBottom || navigator.standalone && !(e & settingsLocalMainbarTop);
}

function pageFrameUrlFix(e, n, t, a) {
    return a && (e = e.replace(/^https?:\/\/[^\/]+/, "")),
    n && (e = e.replace(/^(.*[\?&])uk=[^&#]+(&|)/i, "$1").replace(/^(.*[\?&])nfrd=[^&#]+(&|)/i, "$1")),
    (!navigator.standalone || t) && (e = e.replace(/^(.*[\?&])_slfl(=[^&#]+|)([&#]|$)/i, "$1$3"),
        e = e.replace(/^(.*[\?&])hs(=[^&#]+|)([&#]|$)/i, "$1$3")), e.replace(/^(.*[\?&])_ifx(=[^&#]+|)([&#]|$)/gi, "$1$3").replace(/^(.*[\?&])_nvh(=[^&#]+|)([&#]|$)/gi, "$1$3").replace(/^(.*[\?&])_nvs(=[^&#]+|)([&#]|$)/gi, "$1$3").replace(/&+/, "&").replace(/\?&/, "?").replace(/[\?&]+(#|$)/, "$1");
}

function pageNavScrollGetStorage() {
    try {
        if (window.localStorage && window.localStorage.lus) return window.localStorage.lus;
    } catch (e) {
    }
}

function pageNavScrollInit() {
    var e = env.frame ? parent : window, n = 0;
    e.pageNavPrevLoad && navigator.standalone && env.ios != env.BROWSER_NOT_FOUND && (n = pageNavScrollGetStorage() || 0),
        pageNavScrollHistory(e.history, n, !0)
}

function pageNavScrollHistory(e, n, t) {
    if (!n && e && e.state && (n = parseInt(e.state._ils)),
        !t || n || env.frame && !location.hash) for (var a = 0; 200 > a; a += 50) setTimeout(function () {
        window.hideHeaderPrevent && hideHeaderPrevent(),
            env.scrollTo(0, n)
    }, a)
}

function textInputSaveDelete() {
    try {
        delete localStorage.ltan;
    } catch (e) {
    }
}

function pageNavOnUnload(e) {
    return pageNavUnloadFuncId++, pageNavUnloadFunc[pageNavUnloadFuncId] = {
        fn: e, profile: window.profileVisible
    }, pageNavUnloadFuncId
}

function pageNavOnUnloadRemove(e) {
    0 > e || e > pageNavUnloadFuncId || delete pageNavUnloadFunc[e]
}

function pageNavUnload() {
    if (!pageNavUnloaded) {
        pageNavUnloaded = !0;
        for (var e in pageNavUnloadFunc) "function" == typeof pageNavUnloadFunc[e].fn && pageNavUnloadFunc[e].fn();
        if (env.frame) {
            document._getElementsByTagName && (document.getElementsByTagName = document._getElementsByTagName);
            for (var n = document.getElementsByTagName("IFRAME"), t = 0; t < n.length; t++) removeElement(n[t]);
            purgeAllEventListeners(window)
        }
        if (env.mobile) {
            var a = document.activeElement;
            a && a.blur && a.blur();
        }
    }
}

function pageNavContentWindow() {
    try {
        if (env.fr && env.fr.contentWindow && env.fr.contentWindow.document) return env.fr.contentWindow;
    } catch (e) {
    }
    return window
}

function pageFrameInit() {
    env.mobile && (document.body.style.width = window_size()[0] + "px");
    var e = parent;
    try {
        if (!e.pageNavVersion || e.pageNavVersion < pageNavVersion) return void top.location.replace(location.href);
        e.navHeaderRemove()
    } catch (n) {
    }
    var t = e.env.fr;
    t && (t.style.display = "block", env.msie < 8 && (t.contentDocument = document)),
        setTimeout(function () {
            e.pageLoadingReset && e.pageLoadingReset(), e.mainMenuPageLoad && e.mainMenuPageLoad(),
            e.mainbarAutoHideInit && e.mainbarAutoHideInit(), e.mainbarShow && e.mainbarShow(), Qtv.f("nav-gesture", function () {
                navSwipeDetect()
            }), e.notif_count_set && e.notif_count_set(env.notif), Qtv.f("nav-keyboard", function () {
                e.pageNavFocusStyled && pageNavFocusStyleSet()
            })
        }), document.body.style.setProperty("background-color", "transparent", "important"),
        Qtv.f("nav-frame", function () {
            pageFrameInitFocus()
        })
}

function quizHeaderBg(e) {
    if (!(env.operaMini || env.r.quizid && (env.mobile && env.webkit == env.BROWSER_NOT_FOUND && env.firefox == env.BROWSER_NOT_FOUND || !env.mobile && env.webkit == env.BROWSER_NOT_FOUND && env.firefox == env.BROWSER_NOT_FOUND && env.msie == env.BROWSER_NOT_FOUND || env.chrome < 21 || env.ios < 9 || env.webkit < 537 || env.firefox < 40 || env.msie < 13))) {
        env.safari && !env.mobile && cssStylesAdd("#quizHeaderBgContainer>div{-webkit-filter:none;filter:none}#quizHeaderBgContainer{-webkit-filter:blur(8px) grayscale(50%);filter:blur(8px) grayscale(50%)}"),
        env.mobile && (quizHeaderBgCss && removeElement(quizHeaderBgCss), quizHeaderBgCss = cssStylesAdd("#quizHeaderBgContainer>div{padding-bottom:" + ((mainbarBottom ? 0 : mainbarHeight) + mainbarSizeAdd) + "px}")),
            pageNavOnUnload(function () {
                removeElement($("quizHeaderBgContainer")), removeElement(quizHeaderBgCss);
            }), removeElement($("quizHeaderBgContainer"));
        var n = crel("div", {
            id: "quizHeaderBgContainer"
        }), t = crel("div");
        "#" == e[0] ? setStyleProperty(t, "background-color", e, "important") : e && (t.style.backgroundColor = "",
            t.style.backgroundImage = "url(" + e + ")"), n.appendChild(t);
        var a = $("container") || document.body;
        a.insertBefore(n, a.firstChild), window.pageNavHeader && pageNavHeader[0] && (pageNavHeader[0].opt.trans = 1,
            navHeaderUpdateDisplay(pageNavHeader[0]))
    }
}

function navHeaderSet(e, n) {
    return env.frame && parent != self ? parent.navHeaderSet(e, n) : void Qtv.f("nav-header", function () {
        navHeaderSetInternal(e, n)
    })
}

function mainMenuDisplay(e) {
    return env.frame && parent != window ? parent.mainMenuDisplay(e) : void(mainMenuVisible != e && mainMenuToggle(!0));
}

function mainMenuInit() {
    var e = $("mainMenu");
    if (mainMenuVisible = "block" == getStyle($("mainMenu"), "display"),
        env.fixedPositioning || e && (e.style.height = "auto"), env.UCWeb) {
        var n = $("mainMenuBtn");
        n && (n.innerHTML = "Menu", n.style.color = "#eee", n.style.paddingLeft = "8px", n.style.marginRight = "8px");
    }
    var t = "140px";
    e && !env.mobile && env.msie != env.BROWSER_NOT_FOUND && (e.style.width = t),
        Qtv.f("slide", function () {
            elementSlideInit(e, t, !1, .15, !0, !0), elementSlideInit($("searchMenu"), !1, !0, .3),
            env.r.u && elementSlideInit($("chl"), !0, !1)
        }), mainbarBottom && !env.mobile && (e.scrollTop = 1e4),
        addEventListenerX(window, "resize", mainMenuFooterPosition), mainMenuFooterPosition(),
        mainMenuPageLoad(), Qtv.f("mainmenu", function () {
        mainMenuInitExtra()
    })
}

function mainMenuPageLoad() {
    var e = $("mainMenu"), n = settingsLocalGet(1), t = !0;
    if (!env.mobile && env.r.u) {
        var a = window_size()[0];
        a > 1260 ? env.mainMenuHide || n & settingsLocalMenuHidden || (t = !1) : env.r.u && chat_close()
    } else env.r.u && chat_close();
    t ? (pageBodyPadding(!1), env.fr ? mainMenuDisplay(!1) : e && (e.style.display = "none")) : (pageBodyPadding(!0),
        mainMenuDisplay(!0));
    var i = env.fr;
    !env.mobile && i && i.contentDocument && i.contentDocument.body && (mainbarWidthListener || (mainbarWidthListener = addEventListenerX(window, "resize", setWidthScrollbar)),
        setWidthScrollbar(), setTimeout(function () {
        env.fr.contentWindow.mainMenuTransitionInit();
    }))
}

function setWidthScrollbar() {
    var e = env.fr;
    if (e && e.contentDocument && e.contentDocument.body) {
        var n = document.body.scrollWidth, t = e.contentDocument.body.scrollWidth;
        if (!(50 > n || 50 > t || n - t > 50)) {
            var a = n - t, i = window_size()[0] - a;
            mainbarMarginRight = a, setStyleProperty($("mainbar"), "width", i + "px"),
                setStyleProperty($("notif_list"), "right", a + "px"), setStyleProperty($("chl"), "right", a + "px");
            var o = $(".navHeaderContainer");
            for (var r in o) setStyleProperty(o[r], "width", i + "px");
        }
    }
}

function mainMenuTransitionInit() {
    setTimeout(function () {
        document.body.style["-webkit-transition"] = "all .2s",
            document.body.style.transition = "all .2s ease-in"
    }, 120)
}

function mainMenuToggle(e) {
    if (env.frame && parent != window) return parent.mainMenuToggle(e);
    var n = !1;
    searchMenuVisible() && (n = !0),
    env.mobile && env.r.u && (env.r.tablet ? chatVisible() && ch_actw && chat_win_hide(ch_actw) : (notif_visible || chatVisible()) && (n = !0),
        setTimeout(function () {
            blurActive()
        }));
    var t = $("mainMenu"), a = $("mainbar"), i = mainMenuVisible;
    t && (n || !i ? (!e && env.r.u && settingsLocalSave(1, (settingsLocalGet(1) | settingsLocalMenuVisible) & ~settingsLocalMenuHidden),
        mainMenuVisible = !0, elementSlideOpen(t, function () {
        e || env.mobile && !pageNavFocusStyled || (mainbarBottom ? t.lastChild : t.firstChild).focus(),
            mainMenuFooterPosition()
    }), window.menubarHideAll && menubarHideAll(), window.mainMenuScrollWithPage && mainMenuScrollWithPage(!1),
        mainbarWasHidden = a && "none" == a.style.display, mainbarWasHidden && mainbarShow(), setTimeout(mainMenuFooterPosition),
    mainbarBottom && 0 == t.scrollTop && (t.scrollTop = 1e4), e || env.mobile || (setTimeout(function () {
        pageBodyPadding(!0)
    }), env.r.u && setTimeout(function () {
        chat_resize(null, !0)
    }, 100))) : (!e && env.r.u && settingsLocalSave(1, (settingsLocalGet(1) | settingsLocalMenuHidden) & ~settingsLocalMenuVisible),
        mainMenuVisible = !1, elementSlideClose(t, function () {
        window.menubarHideAll && menubarHideAll();
    }), mainbarWasHidden && (mainbarHide(), mainbarWasHidden = !1), window.mainMenuScrollWithPage && mainMenuScrollWithPage(!0),
    e || env.mobile || (setTimeout(function () {
        pageBodyPadding(!1)
    }), env.r.u && chat_resize(null, !1))));
}

function mainMenuFooterPosition() {
    var e = $("mainMenuFooter");
    if (e) {
        if (mainbarBottom) return e.style.marginBottom = "0",
            void(e.style.marginTop = "0");
        var n = window_size()[1], t = parseInt(e.style.marginTop) || 0,
            a = e.offsetTop + mainbarHeight + mainbarSizeAdd + e.clientHeight;
        n > a ? (e.style.marginTop = n - a + "px", e.style.marginBottom = "0") : t > 0 ? (t -= a - n, 0 > t && (t = 0),
            e.style.marginTop = t + "px", e.style.marginBottom = "0") : e.style.marginBottom = "50px"
    }
}

function pageBodyPadding(e) {
    if (!env.mobile && env.r.u) {
        void 0 == e && (e = mainMenuVisible);
        var n = settingsLocalGet(1), t = "0", a = document.body.style, i = env.fr, o = window_size()[0];
        1260 >= o ? e = !1 : n & settingsLocalChatVisible && (t = "180px"), a.paddingLeft = e ? "140px" : "0",
            a.paddingRight = t;
        try {
            if (i) {
                var r = i.contentDocument;
                if (r && r.body) {
                    var d = r.body.style;
                    d.paddingLeft = e ? "140px" : "0", d.paddingRight = t
                }
            }
        } catch (l) {
        }
        Qtv.m["nav-header"] && navHeaderPadding(e, t);
    }
}

function searchMenuVisible() {
    if (env.frame && parent != window) return parent.searchMenuVisible();
    var e = $("searchMenu");
    return e ? "block" == e.style.display : !1
}

function q_init() {
    if (standaloneLoaderInit) return void document.write("<!-- ");
    var e = settingsLocalGet(1);
    e & settingsLocalNightMode && !hasClassName(document.body, "nightMode") && nightModeToggle(!0),
        pageNavInit(), env.frame || (mainMenuInit(), env.r.u && (env.ch.l && (chat_init(), setTimeout(streamMainLoad)),
        notif_init())), Qtv.f("lazyload", function () {
        setTimeout(function () {
            imgLazyLoad()
        }, 20);
    }), Qtv.f("html", function () {
        setTimeout(htmlUpdateLoad, 100)
    }), env.operaMini || (Qtv.f("fastclick", function () {
        setTimeout(function () {
            FastClickInit()
        }, 20)
    }), scInit2())
}

function q_init2() {
    standaloneLoaderInit || (env.domReady = !0,
        Qtv.f("html", function () {
            setTimeout(function () {
                html_update()
            })
        }), env.operaMini || (Qtv.f("textarea", function () {
        setTimeout(function () {
            textareaExtendAll()
        })
    }), Qtv.f("time", function () {
        setTimeout(function () {
            time_update_locale()
        }), env.msie >= 8 && setInterval(update_q_time, 15e3)
    }), Qtv.f("nav-load", function () {
        pageNavLoadScrollCheck()
    })))
}

!function () {
    function e(e) {
        var n = t.indexOf(e);
        if (-1 != n) {
            var a = t.slice(n + e.length).match(/^(\d+[\._]?\d*)/);
            if (a) return parseFloat(a[1])
        }
        return env.BROWSER_NOT_FOUND;
    }

    function n() {
        var e = window;
        try {
            env.frame && parent != window && (e = parent)
        } catch (n) {
        }
        return e;
    }

    window.env = window.env || {r: {}}, env.BROWSER_NOT_FOUND = 999999, env.gTranslate = "translate.googleusercontent.com" == location.hostname;
    var t = navigator.userAgent;
    if (env.UCWeb = t.match(/UCWEB|zh-CN; rv:1\.2\.3/), env.webLight = t.match(/googleweblight/),
            env.operaMini = env.UCWeb || env.webLight || "[object OperaMini]" === Object.prototype.toString.call(window.operamini) || t.match(/Opera Mini/),
            env.bb10 = -1 != t.indexOf("BB10"), env.nintendo = -1 != t.indexOf("NintendoBrowser"), env.chrome = e("Chrome/"),
            env.ios = env.BROWSER_NOT_FOUND, env.safari = !1, env.webkit = e(" AppleWebKit/"), env.webkit != env.BROWSER_NOT_FOUND) {
        if (env.firefox = env.BROWSER_NOT_FOUND, env.chrome == env.BROWSER_NOT_FOUND) {
            var a = t.match(/(?:iPhone|iPod|iPad).*? OS ([0-9]+)_*([0-9]*)/);
            a && (env.ios = parseFloat(a[1] + (a[2] ? "." + a[2] : ""))), env.safari = -1 != t.indexOf("Safari/") && -1 != t.indexOf("Mac OS X");
        }
    } else env.webkit = e("AppleWebKit"), env.firefox = e(" Firefox/");
    if (env.android = e(" Android "),
        env.android == env.BROWSER_NOT_FOUND && (env.android = e(" Android/")), env.android == env.BROWSER_NOT_FOUND && env.ios == env.BROWSER_NOT_FOUND) if (t.match(/Silk-Accelerated/)) env.android = 4; else if (t.match(/ Silk\//) && !t.match(/PlayStation/i)) env.android = 4.4; else if (env.safari && "ontouchstart" in window) {
        env.safari = !1;
        var i = t.match(/^Mozilla\/5\.0 \(Macintosh; (U; |)Intel Mac OS X 10_([0-9_]+)(; en-us|)\) AppleWebKit\/([0-9\.]+) \(KHTML, like Gecko\) Version\/([0-9\.]+) Safari\/([A-Z0-9\.]+)$/);
        if (i) {
            var o = i[2], r = i[4], d = i[5], l = i[6];
            "12" != o || "602.1.50" != r && "602.4.6" != r || "10.0" != d || "602.1.31" != l ? "11" == o && "601.1.46" == r && "9.0" == d && "601.1.42" == l ? env.ios = 9 : "10" == o && "538.44" == r && "8.0" == d && "538.44" == l ? env.ios = 8 : "9_3" == o && "537.75.14" == r && "7.0.3" == d && "7046A194A" == l ? env.ios = 7 : i[1] && i[3] && "6_3" == o && "533.16" == r && "5.0" == d && "533.16" == l ? env.android = 2.2 : "10" == o && "537.16" == r && "8.0" == d && "537.16" == l ? env.android = 4.4 : "9_5" == o && "700.1.17" == r && "7.1" == d && "537.85.10" == l ? env.mobile = !0 : (env.mobile = !0,
                window.onerror("iDtp " + t)) : env.ios = 10
        } else env.mobile = !0, window.onerror("iDtp " + t);
    } else if (env.chrome != env.BROWSER_NOT_FOUND && (t.match("X11; Linux x86_64") && !navigator.platform.match("x86_64") || env.chrome < 22 && "ontouchstart" in window)) {
        if (env.android = 4, env.chrome >= 43 && (env.android = 4.4), !cookieGet("crmb")) {
            var s = new Date;
            s.setDate(s.getDate() + 1), document.cookie = "crmb=1; path=/; expires=" + s.toGMTString(),
                setTimeout(function () {
                    location.replace(location.href)
                }, 500), cssStylesAdd("#container { display: none !important; }");
        }
    } else env.firefox < 41 && t.match("Android") ? env.android = 4 : env.mobile && env.chrome != env.BROWSER_NOT_FOUND && env.chrome > 20 && (env.android = 4.4);
    if (env.msie = e(" Trident/"), env.msie != env.BROWSER_NOT_FOUND ? env.msie += 4 : (env.msie = e(" Edge/"),
        env.msie == env.BROWSER_NOT_FOUND && (env.msie = e(" MSIE "))), env.iemobile = env.BROWSER_NOT_FOUND,
            env.msie != env.BROWSER_NOT_FOUND ? (env.iemobile = e(" IEMobile/"), env.iemobile == env.BROWSER_NOT_FOUND && t.match(/ WPDesktop;/) && (env.iemobile = env.msie),
                env.chrome = env.BROWSER_NOT_FOUND, env.webkit = env.BROWSER_NOT_FOUND, env.safari = !1, env.android = env.BROWSER_NOT_FOUND,
                env.ios = env.BROWSER_NOT_FOUND) : env.android != env.BROWSER_NOT_FOUND && ((env.android < 4 || env.chrome < 18 || env.webkit < 535.19) && (env.chrome = env.BROWSER_NOT_FOUND),
                env.safari = !1, env.ios = env.BROWSER_NOT_FOUND), env.chromeView = env.chrome != env.BROWSER_NOT_FOUND && t.match(/Version\/|SamsungBrowser|OPR\/|UCBrowser|Puffin|Dolphin|Dolfin|YaBrowser/),
            env.mobile = env.mobile || env.r.mobile || env.android != env.BROWSER_NOT_FOUND || env.ios != env.BROWSER_NOT_FOUND || env.iemobile != env.BROWSER_NOT_FOUND || env.operaMini || env.bb10,
            env.mac = !env.mobile && -1 != t.indexOf("Macintosh"), env.scrollSupport = function () {
            return env.operaMini ? !1 : env.mobile ? env.ios >= 7 && env.android >= 4 && (env.chrome != env.BROWSER_NOT_FOUND || env.android >= 4.4) && env.webkit >= 537.36 && "ontouchstart" in window ? !0 : env.iemobile != env.BROWSER_NOT_FOUND && env.iemobile >= 7 ? !0 : env.firefox != env.BROWSER_NOT_FOUND ? !0 : !1 : !0;
        }(), env.scrollSupportInFrame = env.scrollSupport && env.android == env.BROWSER_NOT_FOUND,
            env.fixedPositioning = !(env.operaMini || env.msie < 7 || env.android < 2.2 || env.iemobile < 10 || env.ios < 5 || env.mobile && env.android == env.BROWSER_NOT_FOUND && env.webkit < 534),
            env.historySupport = !env.operaMini && env.msie >= 10 && env.iemobile >= 15 && (env.android >= 4.4 || env.chrome != env.BROWSER_NOT_FOUND) && env.ios >= 6 && env.webkit >= 535 && "undefined" != typeof window.history && "undefined" != typeof history.pushState && "undefined" != typeof history.replaceState,
            env.modern = !env.operaMini && !env.r.b && env.android >= 4.3 && env.ios >= 6 && env.webkit >= 535 && env.firefox >= 11 && env.msie >= 10 && env.iemobile >= 15 && env.historySupport && env.fixedPositioning,
        env.chrome != env.BROWSER_NOT_FOUND && !navigator.standalone && window.matchMedia) {
        var a = window.matchMedia("all and (display-mode: standalone)");
        a && a.matches && (navigator.standalone = !0)
    }
    env.scrollBy = function (e, n) {
        return env.ios != env.BROWSER_NOT_FOUND ? (env.frame ? parent : window).scrollBy(e, n) : env.fr && env.fr.contentWindow ? env.fr.contentWindow.scrollBy(e, n) : window.scrollBy(e, n);
    }, env.scrollTo = function (e, n) {
        return env.ios != env.BROWSER_NOT_FOUND ? (env.frame ? parent : window).scrollTo(e, n) : env.fr && env.fr.contentWindow ? env.fr.contentWindow.scrollTo(e, n) : window.scrollTo(e, n);
    }, env.history = {
        target: n, pushState: function (e, t, a) {
            env.historySupport && n().history.pushState(e, t, a);
        }, replaceState: function (e, t, a) {
            env.historySupport && n().history.pushState(e, t, a)
        }
    },
        env.setTitle = function (e) {
            document.title = e;
            try {
                env.frame && parent != window && (parent.document.title = e);
            } catch (n) {
            }
        }
}();
var localStorageError = !1, pageNavVersion = 235, pagesLoaded = 0, pageNavLoading = 0, pageNavSkipState = !1,
    pageNavPrevLoad = !1, pageFrameOld = null, pageNavLoadScrollTo = 0, pageNavFirstPage = "", pageWidthPortrait,
    pageWidthLandscape, pageNavFocusStyled = !1, menuVisible = !1, mainbarHidden = !1, mainbarHeight = 55,
    mainbarSizeAdd = 0, mainbarSizeAdd2 = 0, standaloneLoaderVersion = 27, standaloneLoaderInit,
    pageNavInitContainerOpacity = null, navHistory = [], navHistorySkip = !1, pageNavLoadScrollTo = 0,
    mainbarBottomCssElem = null, mainbarBottom = !1, pageNavUnloadFunc = {}, pageNavUnloadFuncId = 0,
    pageNavUnloaded, quizHeaderBgCss = null, mainbarWidthListener, mainbarMarginRight = 0, mainbarWasHidden,
    mainMenuVisible = !1;
!function () {
    try {
        pageNavPreInit(), scInit()
    } catch (e) {
    }
}();
