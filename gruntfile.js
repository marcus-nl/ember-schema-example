module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-wiredep');
  grunt.initConfig({
    wiredep: {
      app: {
        src: 'src/main/resources/static/index.html'
      }
    }
  });
}
