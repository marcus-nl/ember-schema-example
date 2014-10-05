module.exports = function(grunt) {
  grunt.loadNpmTasks('grunt-wiredep');
  grunt.initConfig({
    wiredep: {
      target: {
        src: ['src/main/resources/static/index.html']
      }
    }
  });
}
