var App = Ember.Application.createWithMixins({
  LOG_TRANSITIONS: true,
  LOG_BINDINGS: true,
  LOG_VIEW_LOOKUPS: true,
  LOG_STACKTRACE_ON_DEPRECATION: true,
  LOG_VERSION: true,
  debugMode: true,
  
  init: function() {
    var app = this;
    app.deferReadiness();

    $.ajax({ 
      url: 'http://localhost:8080/ember-schema'
    }).then(function(schema) {
      var schemaLoader = SchemaLoader.create({ target: app, container: app });
      schemaLoader.load(schema);
      app.advanceReadiness();
    });
    this._super();
  }
});

App.ApplicationAdapter = DS.RESTAdapter;

App.IndexRoute = Ember.Route.extend({
  model: function(params) {
    return this.store.find('zoo', 1);
  }
});
