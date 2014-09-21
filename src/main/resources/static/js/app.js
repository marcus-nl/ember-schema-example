var App = Ember.Application.createWithMixins({
  LOG_TRANSITIONS: true,
  LOG_BINDINGS: true,
  LOG_VIEW_LOOKUPS: true,
  LOG_STACKTRACE_ON_DEPRECATION: true,
  LOG_VERSION: true,
  debugMode: true,  
});

App.ApplicationAdapter = DS.RESTAdapter;

App.IndexRoute = Ember.Route.extend({
  model: function(params) {
    return this.store.find('zoo', 1);
  }
});
