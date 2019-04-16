function handleSubmit(xhr, status, args, dialog) {
    var jqDialog = jQuery('#'+dialog.id);
    if(args.validationFailed) {
        jqDialog.effect('shake', { times:3 }, 100);
    } else {
        dialog.hide();
    }
}
function resetWizard() {
    wiz.loadStep(wiz.cfg.steps[0], true);
}
