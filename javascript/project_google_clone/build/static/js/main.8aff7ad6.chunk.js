(this["webpackJsonpgoogle-clone"]=this["webpackJsonpgoogle-clone"]||[]).push([[0],{76:function(e,t,r){},77:function(e,t,r){"use strict";r.r(t);var s=r(0),c=r(21),a=r.n(c),n=r(11),l=r(10),i=r(1),d=function(){return Object(i.jsx)("div",{className:"text-center p-10 mt-10 border-t dark:border-gray-700 border-gray-200 ",children:"\xa9 2021 Goggl, Inc."})},o=r(79),j=r(15),u=r.n(j),b=r(22),x=Object(s.createContext)(),h=function(e){var t=e.children,r=Object(s.useState)([]),c=Object(l.a)(r,2),a=c[0],n=c[1],d=Object(s.useState)(!1),o=Object(l.a)(d,2),j=o[0],h=o[1],m=Object(s.useState)(""),f=Object(l.a)(m,2),p=f[0],O=f[1],v=function(){var e=Object(b.a)(u.a.mark((function e(t){var r,s;return u.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return h(!0),e.next=3,fetch("".concat("https://google-search3.p.rapidapi.com/api/v1").concat(t),{method:"GET",headers:{"x-user-agent":"desktop","x-rapidapi-host":"google-search3.p.rapidapi.com","x-rapidapi-key":"d025593600msh4513fa4a68c363bp13810ajsn48a74148d10f"}});case 3:return r=e.sent,e.next=6,r.json();case 6:s=e.sent,n(s),h(!1);case 9:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}();return Object(i.jsx)(x.Provider,{value:{getResults:v,results:a,searchTerm:p,setSearchTerm:O,loading:j},children:t})},m=function(){return Object(s.useContext)(x)},f=[{url:"/search",text:"\ud83d\udd0e All"},{url:"/news",text:"\ud83d\udcf0 News"},{url:"/images",text:"\ud83d\udcf8 Images"},{url:"/videos",text:"\ud83d\udcfa Videos"}],p=function(){return Object(i.jsx)("div",{className:"flex sm:justify-around justify-between items-center mt-4",children:f.map((function(e){var t=e.url,r=e.text;return Object(i.jsx)(n.c,{to:t,activeClassName:"text-blue-700 border-b-2 dark:text-blue-300 border-blue-700 pb-2",children:r})}))})},O=function(){var e=m().setSearchTerm,t=Object(s.useState)(""),r=Object(l.a)(t,2),c=r[0],a=r[1],n=Object(o.a)(c,300),d=Object(l.a)(n,1)[0];return Object(s.useEffect)((function(){d&&e(d)}),[d]),Object(i.jsxs)("div",{className:"relative sm:ml-48 md:ml-72 sm:-mt-10 mt-3",children:[Object(i.jsx)("input",{value:c,type:"text",className:"sm:w-96 w-80 h-10 dark:bg-gray-200  border rounded-full shadow-sm outline-none p-6 text-black hover:shadow-lg",placeholder:"\ud83d\udd0e Search Google or type URL",onChange:function(e){return a(e.target.value)}}),""!==c&&Object(i.jsx)("button",{type:"button",className:"absolute top-1.5 right-4 text-2xl text-gray-500 ",onClick:function(){return a("")},children:"x"}),Object(i.jsx)(p,{})]})},v=function(e){var t=e.setDarkTheme,r=e.darkTheme;return Object(i.jsxs)("div",{className:"p-5 pb-0 flex flex-wrap sm:justify-between justify-center items-center border-b dark:border-gray-700 border-gray-200 ",children:[Object(i.jsxs)("div",{className:"flex justify-between items-center space-x-5 w-screen ",children:[Object(i.jsx)(n.b,{to:"/",children:Object(i.jsx)("p",{className:"text-2xl bg-blue-500 font-bold text-white py-1 px-2 rounded dark:bg-gray-50 dark:text-gray-900",children:"Brunogle \ud83d\udd0e"})}),Object(i.jsx)("button",{type:"button",onClick:function(){return t(!r)},className:"text-xl dark:bg-gray-50 dark:text-gray-900 bg-white border rounded-full px-2 py-1 hover:shadow-lg",children:r?"\ud83d\udca1 Light":"\ud83c\udf19 Dark"})]}),Object(i.jsx)(O,{})]})},g=r(3),k=r(25),w=r.n(k),y=r(26),N=r.n(y),T=function(){return Object(i.jsx)("div",{className:"flex justify-center items-center ",children:Object(i.jsx)(N.a,{type:"Puff",color:"#00BFFF",height:550,width:80})})},S=function(){var e,t,r,c,a=m(),n=a.results,l=a.loading,d=a.getResults,o=a.searchTerm,j=Object(g.g)();if(Object(s.useEffect)((function(){""!==o&&("/videos"===j.pathname?d("/search/q=".concat(o," videos")):d("".concat(j.pathname,"/q=").concat(o,"&num=40")))}),[o,j.pathname]),l)return Object(i.jsx)(T,{});switch(j.pathname){case"/search":return Object(i.jsx)("div",{className:"sm:px-56 flex flex-wrap justify-between space-y-6",children:null===n||void 0===n||null===(e=n.results)||void 0===e?void 0:e.map((function(e,t){var r=e.link,s=e.title;return Object(i.jsx)("div",{className:"md:w-2/5 w-full",children:Object(i.jsxs)("a",{href:r,target:"_blank",rel:"noreferrer",children:[Object(i.jsx)("p",{className:"text-sm",children:r.length>30?r.substring(0,30):r}),Object(i.jsx)("p",{className:"text-lg hover:underline dark:text-blue-300 text-blue-700  ",children:s})]})},t)}))});case"/images":return Object(i.jsx)("div",{className:"flex flex-wrap justify-center items-center",children:null===n||void 0===n||null===(t=n.results)||void 0===t?void 0:t.map((function(e,t){var r=e.image,s=e.link,c=s.href,a=s.title;return Object(i.jsxs)("a",{href:c,target:"_blank",rel:"noreferrer",className:"sm:p-3 p-5",children:[Object(i.jsx)("img",{src:null===r||void 0===r?void 0:r.src,alt:a,loading:"lazy"}),Object(i.jsx)("p",{className:"sm:w-36 w-36 break-words text-sm mt-2",children:a})]},t)}))});case"/news":return Object(i.jsx)("div",{className:"sm:px-56 flex flex-wrap justify-between items-center space-y-6",children:null===n||void 0===n||null===(r=n.entries)||void 0===r?void 0:r.map((function(e){var t=e.id,r=e.links,s=e.source,c=e.title;return Object(i.jsxs)("div",{className:"md:w-2/5 w-full ",children:[Object(i.jsx)("a",{href:null===r||void 0===r?void 0:r[0].href,target:"_blank",rel:"noreferrer ",className:"hover:underline ",children:Object(i.jsx)("p",{className:"text-lg dark:text-blue-300 text-blue-700",children:c})}),Object(i.jsx)("div",{className:"flex gap-4",children:Object(i.jsxs)("a",{href:null===s||void 0===s?void 0:s.href,target:"_blank",rel:"noreferrer",className:"hover:underline hover:text-blue-300",children:[" ",null===s||void 0===s?void 0:s.href]})})]},t)}))});case"/videos":return Object(i.jsx)("div",{className:"flex flex-wrap ",children:null===n||void 0===n||null===(c=n.results)||void 0===c?void 0:c.map((function(e,t){var r;return Object(i.jsx)("div",{className:"p-2",children:Object(i.jsx)(w.a,{url:null===(r=e.additional_links)||void 0===r?void 0:r[0].href,controls:!0,width:"355px",height:"200px"})},t)}))});default:return"Error..."}},C=function(){return Object(i.jsx)("div",{className:"p-4",children:Object(i.jsxs)(g.d,{children:[Object(i.jsx)(g.b,{exact:!0,path:"/",children:Object(i.jsx)(g.a,{to:"/search"})}),Object(i.jsx)(g.b,{exact:!0,path:"/search",children:Object(i.jsx)(S,{})}),Object(i.jsx)(g.b,{path:"/images",children:Object(i.jsx)(S,{})}),Object(i.jsx)(g.b,{path:"/news",children:Object(i.jsx)(S,{})}),Object(i.jsx)(g.b,{path:"/videos",children:Object(i.jsx)(S,{})})]})})},E=function(){var e=Object(s.useState)(!0),t=Object(l.a)(e,2),r=t[0],c=t[1];return Object(i.jsx)("div",{className:r?"dark":"",children:Object(i.jsxs)("div",{className:"dark:bg-gray-900 bg-gray-100 dark:text-gray-200 black min-h-screen",children:[Object(i.jsx)(v,{setDarkTheme:c,darkTheme:r}),Object(i.jsx)(C,{}),Object(i.jsx)(d,{})]})})};r(76);a.a.render(Object(i.jsx)(h,{children:Object(i.jsx)(n.a,{children:Object(i.jsx)(E,{})})}),document.getElementById("root"))}},[[77,1,2]]]);
//# sourceMappingURL=main.8aff7ad6.chunk.js.map