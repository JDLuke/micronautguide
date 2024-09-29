const core = require('@actions/core');

const environment = '${{ inputs.environment }}';
console.log("Environment: " + environment);
try {
    const parsed = JSON.parse(environment);
    console.log('Parsed: ' + parsed);
    for(let key in parsed) {
        if (parsed.hasOwnProperty(key)) {
            console.log(key + ': ' + obj[key]);
        }
    }
} catch (error) {
    console.error("Error parsing JSON:", error);
    core.setFailed(error.message);
}
