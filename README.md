# plugin-jam-system
Vue + Spring-Boot System handling plugin jams:

Following are the planned features:

1. File uploading
  - [ ] World upload
  - [ ] Plugin upload (Superseded by 4.)
2. Discord Bot Settings for TeamLeader
  - [ ] Project Description
  - [ ] Team name editing
  - [ ] Link to Github
3. Orga dashboard
  - [ ] Team status
    - [ ] active Deployments
    - [ ] World downloads
    - [ ] plugin jar downloads
4. Server management
  - [ ] Allow preinstalled framework selectionFrameworks
  - [ ] Max Playercount
  - [ ] Server restart
  - [ ] Redeployment request
    - [ ] Select which buildtool should be used (maven or gradle)
    - [ ] Task selection
    - [ ] Artifact path and file name declaration
5. OAuth2
   - [x] Discord 

---
## Build image and run container

We decided against a multistep docker image with a build step for the jar artifact.
Observations have shown that the whole process took way longer than building the artifact local.

1. `cd app`
2. `./gradlew clean build`
3. `cd ../docker/`

### Docker 

4. `docker-compose build` 
5. `docker-compose up -d`

### Kubernetes with nerdctl and kubectl

4. `nerdctl --namespace k8s.io compose build`
5. `kubectl apply -f kubernetes/database-persistence.yaml` to create persistence data claim separately. We don't want to lose the data when we redeploy. 
7. `kubectl apply -k kubernetes`

### Considerations regarding improving the container setup

- Not adding the config file on image build instead
  - Docker: Mount the config as volume
  - Kubernetes: Create a configMap using the config file and mount it as well
