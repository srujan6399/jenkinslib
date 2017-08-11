#!/usr/bin/env groovy


def call(body) {

  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
  
  def status = config.status
  def attachment = config.attachment

    String tolist="srujan.d87@gmail.com";
    String sub="CI Jenkins ${status}: Job[${env.JOB_NAME}][${env.BUILD_NUMBER}]";
    String bdy="<p>This Email is for Demo purpose only -${status}: Job'[${env.JOB_NAME}][${env.BUILD_NUMBER}]':</p>"+
                "<p><b>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME}[${env.BUILD_NUMBER}]</a></b></p>";
     
    emailext body: bdy, subject: sub, to:tolist, mimeType: 'text/html', attachmentsPattern: attachment

 
 }
