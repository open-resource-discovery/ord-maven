# Dependency installation security

Use npm 11.20.0 or later for repository development.
CI bootstraps npm 11.20.0 before npm commands.
Published consumer engine requirements are unchanged.

Install from the committed lockfiles with npm ci.
npm applies the two-day minimum release age when it resolves versions, including lockfile updates.
When npm ci reuses a valid lockfile, it does not independently recheck release age.

The `tools/annotation-gen` project sets `ignore-scripts=true` to skip dependency install scripts.
Run generation commands explicitly. `npm run` runs the named script and skips its automatic pre- and post-scripts.
If scripts are enabled explicitly, `strict-allow-scripts` rejects unreviewed dependency scripts.
Review a dependency script and its registry identity/integrity before changing its entry to true.
Avoid scope-wide age exceptions, and use a documented package/version exception only for an urgent reviewed security fix.

Policy roots:

- tools/annotation-gen

After updating dependencies, review lockfile packages marked hasInstallScript and update the version-specific decisions.
In `tools/annotation-gen`, verify `ignore-scripts`, `min-release-age`, and `strict-allow-scripts` with `npm config get`.
Unsupported clients may ignore these controls; the documented development client and CI pin are part of the policy.
