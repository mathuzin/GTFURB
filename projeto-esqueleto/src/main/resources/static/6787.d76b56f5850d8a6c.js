"use strict";(self.webpackChunkapp=self.webpackChunkapp||[]).push([[6787],{8378:(L,u,r)=>{r.r(u),r.d(u,{FormEscolaPageModule:()=>F});var m=r(9808),l=r(3075),e=r(9928),i=r(8555),f=r(655),o=r(6435),d=r(7766),p=r(6939),v=r(1424),g=r(442),h=r(1062);const Z=function(t,s){return{required:t,maxlength:s}},A=[{path:":id",component:(()=>{class t{constructor(a,n,c,P,y){this.formBuilder=a,this.navController=n,this.escolaService=c,this.appErroService=P,this.activatedRoute=y}ngOnInit(){this.form=this.formBuilder.group({id:[],nome:[null,l.kI.compose([l.kI.required,l.kI.maxLength(155)])]})}ionViewWillEnter(){this.activatedRoute.snapshot.data.entity&&this.form.patchValue(this.activatedRoute.snapshot.data.entity)}salvar(){return(0,f.mG)(this,void 0,void 0,function*(){try{if(this.form.valid){const a=this.form.getRawValue();"new"===a.id&&delete a.id,this.form.disable(),a.id?yield this.escolaService.update(a.id,a).toPromise():yield this.escolaService.insert(a).toPromise(),this.fechar()}else this.form.markAllAsTouched()}catch(a){yield this.appErroService.exibirErros(a.error.message)}this.form.enable()})}fechar(){this.navController.back()}}return t.\u0275fac=function(a){return new(a||t)(o.Y36(l.qu),o.Y36(e.SH),o.Y36(d.v),o.Y36(p.R),o.Y36(i.gz))},t.\u0275cmp=o.Xpm({type:t,selectors:[["app-form-escola"]],decls:43,vars:35,consts:[["slot","start"],["defaultHref","/professor/escolas",3,"text"],[1,"container-fluid"],["mode","md",1,"no-border"],[1,"p-0","pt-3"],["lines","none"],[2,"font-size","20px"],[2,"font-size","12px"],[1,"row","mt-2",3,"formGroup"],[1,"col-12","mt-3"],[1,"p-float-label"],["id","float-input","formControlName","nome","type","text","pInputText","","autocomplete","off",1,"w-100"],["for","float-input",1,"required"],[3,"control","errorMessages"],[1,"w-100","p-2","pl-4","btn-container"],[1,"text-left"],["fill","clear","color","dark",3,"click"],[3,"disabled","click"]],template:function(a,n){1&a&&(o.TgZ(0,"ion-content")(1,"ion-toolbar")(2,"ion-buttons",0),o._UZ(3,"ion-back-button",1),o.ALo(4,"translate"),o.qZA()(),o.TgZ(5,"div",2)(6,"ion-card",3)(7,"ion-card-header",4)(8,"ion-item",5)(9,"ion-label")(10,"ion-card-title",6),o._uU(11),o.ALo(12,"translate"),o.ALo(13,"translate"),o.qZA(),o.TgZ(14,"ion-card-subtitle",7),o._uU(15),o.ALo(16,"translate"),o.ALo(17,"translate"),o.qZA()()()(),o.TgZ(18,"ion-card-content")(19,"form",8)(20,"div",9)(21,"span",10),o._UZ(22,"input",11),o.TgZ(23,"label",12),o._uU(24),o.ALo(25,"translate"),o.qZA()(),o._UZ(26,"app-validador",13),o.ALo(27,"translate"),o.ALo(28,"translate"),o.qZA()()()(),o.TgZ(29,"div",14)(30,"div",15)(31,"ion-button",16),o.NdJ("click",function(){return n.fechar()}),o._uU(32),o.ALo(33,"translate"),o.qZA(),o.TgZ(34,"ion-button",17),o.NdJ("click",function(){return n.salvar()}),o._uU(35),o.ALo(36,"translate"),o.ALo(37,"translate"),o.qZA()()()(),o._UZ(38,"br")(39,"br")(40,"br")(41,"br")(42,"br"),o.qZA()),2&a&&(o.xp6(3),o.s9C("text",o.lcZ(4,10,"furbot.voltar")),o.xp6(8),o.Oqu(n.form.get("id").value?o.lcZ(12,12,"furbot.atualizar"):o.lcZ(13,14,"furbot.cadastrar")),o.xp6(4),o.hij("",n.form.get("id").value?o.lcZ(16,16,"furbot.dadosParaAtualizarEscola"):o.lcZ(17,18,"furbot.dadosParaCadastrarEscola")," "),o.xp6(4),o.Q6J("formGroup",n.form),o.xp6(5),o.Oqu(o.lcZ(25,20,"furbot.nomeDaEscola")),o.xp6(2),o.Q6J("control",n.form.get("nome"))("errorMessages",o.WLB(32,Z,o.lcZ(27,22,"furbot.required"),o.lcZ(28,24,"furbot.maxLengthNome"))),o.xp6(6),o.Oqu(o.lcZ(33,26,"furbot.cancelar")),o.xp6(2),o.Q6J("disabled",n.form.disabled),o.xp6(1),o.Oqu(n.form.get("id").value?o.lcZ(37,30,"furbot.atualizar"):o.lcZ(36,28,"furbot.cadastrar")))},directives:[e.W2,e.sr,e.Sm,e.oU,e.cs,e.PM,e.Zi,e.Ie,e.Q$,e.Dq,e.tO,e.FN,l._Y,l.JL,l.sg,l.Fj,l.JJ,l.u,v.o,g.W,e.YG],pipes:[h.X$],styles:[""]}),t})(),resolve:{entity:(()=>{class t{constructor(a){this.service=a}resolve(a){if("new"!==a.paramMap.get("id"))return this.service.get(a.paramMap.get("id"))}}return t.\u0275fac=function(a){return new(a||t)(o.LFG(d.v))},t.\u0275prov=o.Yz7({token:t,factory:t.\u0275fac,providedIn:"root"}),t})()}}];let b=(()=>{class t{}return t.\u0275fac=function(a){return new(a||t)},t.\u0275mod=o.oAB({type:t}),t.\u0275inj=o.cJS({imports:[[i.Bz.forChild(A)],i.Bz]}),t})();var E=r(4466);let F=(()=>{class t{}return t.\u0275fac=function(a){return new(a||t)},t.\u0275mod=o.oAB({type:t}),t.\u0275inj=o.cJS({imports:[[m.ez,l.u5,e.Pc,b,E.m,l.UX]]}),t})()}}]);